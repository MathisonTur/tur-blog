package com.blog.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.RedisConstants;
import com.blog.mapper.ArticleMapper;
import com.blog.pojo.dto.ArticleLatestDTO;
import com.blog.pojo.entity.Article;
import com.blog.pojo.vo.ArticleCategoryOrTagVO;
import com.blog.pojo.vo.ArticleInfoVO;
import com.blog.pojo.vo.ArticleListVO;
import com.blog.service.intf.*;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.blog.enums.PublishEnum.PUBLISH;

/**
* @author tur
* @description 博客文章表服务
* @version 1.0
* @date 2023-04-06
*/
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private TagService tagService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleTagService articleTagService;

    @Resource
    private RedisService redisService;

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    //=================================== web方法 ================================
    /**
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return com.blog.util.ResponseResult
     * @description 分页获取文章列表
     */
    @Override
    public ResponseResult getArticlePage(Long pageNo, Long pageSize) {
        return ResponseResult.success(getArticleList(pageNo, pageSize, null, null));
    }

    /**
     * @param categoryId 分类id
     * @param tagId      标签id
     * @param pageNo     页码
     * @param pageSize   每页数量
     * @return com.blog.utils.ResponseResult
     * @description 分类or标签文章列表
     */
    @Override
    public ResponseResult condition(Long categoryId, Long tagId, Long pageNo, Long pageSize) {
        Page<ArticleListVO> articleVOPage = getArticleList(pageNo, pageSize, categoryId, tagId);
        String name = categoryId == null ? tagService.getTagById(tagId).getName() : categoryService.getCategoryById(categoryId).getName();
        ArticleCategoryOrTagVO articleCategoryOrTagVO = new ArticleCategoryOrTagVO(articleVOPage.getRecords(), name);
        return ResponseResult.success(articleCategoryOrTagVO);
    }

    /**
     * @param id 文章id
     * @return com.blog.utils.ResponseResult
     * @description 根据文章id获取文章详情
     */
    @Override
    public ResponseResult articleInfo(Long id) {
        // 根据id查询文章，并将数据拷贝至ArticleInfoVO
        ArticleInfoVO articleInfoVO = BeanCopyUntils.copyBean(baseMapper.selectById(id), ArticleInfoVO.class);
        // 获取分类
        articleInfoVO.setCategory(categoryService.getCategoryById(articleInfoVO.getCategoryId()));
        // 获取标签集合
        articleInfoVO.setTagBOList(tagService.getTagByArticleId(id));
        // 获取评论集合
        // articleInfoVO.setComments(commentService.selectByArticleId(id));

        // 获取最新的五篇文章
        List<ArticleLatestDTO> latestArticleVOList = BeanCopyUntils.copyBeanList(baseMapper.getNewestArticleList(id, PUBLISH.getCode()), ArticleLatestDTO.class);
        articleInfoVO.setNewestArticleList(latestArticleVOList);

        // 获取上一篇文章
        Article lastArticle = baseMapper.getLastOrNextArticle(id, PUBLISH.getCode(), 0);
        ArticleLatestDTO lastArticleVO = lastArticle == null ? null : BeanCopyUntils.copyBean(lastArticle, ArticleLatestDTO.class);
        articleInfoVO.setLastArticle(lastArticleVO);

        // 获取下一篇文章
        Article nextArticle = baseMapper.getLastOrNextArticle(id, PUBLISH.getCode(), 1);
        ArticleLatestDTO nextArticleVO = nextArticle == null ? null : BeanCopyUntils.copyBean(nextArticle, ArticleLatestDTO.class);
        articleInfoVO.setNextArticle(nextArticleVO);

        // 根据分类获取推荐文章
        List<ArticleLatestDTO> recommendArticleList = BeanCopyUntils.copyBeanList(baseMapper.getRecommendArticleList(id), ArticleLatestDTO.class);
        articleInfoVO.setRecommendArticleList(recommendArticleList);

        // 点赞量
        articleInfoVO.setLikeCount((Integer) redisService.hGet(RedisConstants.ARTICLE_LIKE_COUNT, id.toString()));
        // 阅读量
        articleInfoVO.setQuantity((Integer) redisService.getCacheMap(RedisConstants.ARTICLE_READING).get(id.toString()));

        // 增加文章阅读量
        threadPoolTaskExecutor.execute(() -> this.readIncr(id, RedisConstants.ARTICLE_READING));

        // 校验私密文章是否已经进行过验证
        // 待实现

        return ResponseResult.success(articleInfoVO);
    }

    /**
     * @param id 文章id
     * @return com.blog.utils.ResponseResult
     * @description 文章点赞
     */
    @Override
    public ResponseResult articleLike(Long id) {
        String articleLikeKey = RedisConstants.ARTICLE_USER_LIKE + StpUtil.getLoginId();
        if (redisService.sIsMember(articleLikeKey, id)){
            // 点过赞则删除文章id
            redisService.sRemove(articleLikeKey, id);
            // 文章点赞量-1
            redisService.hDecr(RedisConstants.ARTICLE_LIKE_COUNT, id.toString(), 1L);
        }else{
            // 未点赞则增加文章id
            redisService.sAdd(articleLikeKey, id);
            // 文章点亮+1
            redisService.hIncr(RedisConstants.ARTICLE_LIKE_COUNT, id.toString(), 1L);
        }
        return ResponseResult.success();
    }

    /**
     * @param categoryId 分类id
     * @return java.util.List<com.blog.model.vo.ArticleVO>
     * @description 根据分类id获取文章数量
     */
    @Override
    public Long selectByCategoryId(Long categoryId) {
        return baseMapper.selectByCategoryId(categoryId, PUBLISH.getCode());
    }

    /**
     * @param code 验证码
     * @return com.blog.utils.ResponseResult
     * @description 校验密钥
     */
    @Override
    public ResponseResult checkSecret(String code) {
        return null;
    }


    //======================== 其他服务方法 ===============================
    /**
     * @return java.lang.Long
     * @description 查询已发布的文章数量
     */
    @Override
    public Long selectCount() {
        return baseMapper.selectCount(PUBLISH.getCode());
    }


    //============================= 自定义方法 =============================
    /**
     * @description 分页获取文章列表
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @param categoryId 分类id
     * @param tagId 标签id
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.blog.service.intf.pojo.vo.ArticleListVO>
    */
    private Page<ArticleListVO> getArticleList(Long pageNo, Long pageSize, Long categoryId, Long tagId){
        List<Long> articleId = null;
        if (tagId != null){
            articleId = new ArrayList<>();
            List<Long> finalArticleId = articleId;
            articleTagService.selectByTagId(tagId).forEach(articleTag -> finalArticleId.add(articleTag.getArticleId()));
        }
        Page<Article> articlePage = baseMapper.selectArticleList(new Page<>(pageNo, pageSize), PUBLISH.getCode(), articleId, categoryId);
        Page<ArticleListVO> articleVOList = BeanCopyUntils.copyBeanPage(articlePage, ArticleListVO.class);
        articleVOList.getRecords().forEach(articleVO -> {
            articleVO.setTagBOList(tagService.getTagByArticleId(articleVO.getId()));
            articleVO.setCategoryName(categoryService.getCategoryById(articleVO.getCategoryId()).getName());
        });
        return articleVOList;
    }

    /**
     * @description 增加文字阅读量或标签点击量
     * @param id redis键
     * @param key map键
     */
    private void readIncr(Long id, String key){
        Map<String, Object> map = redisService.getCacheMap(key);
        Integer value = (Integer) map.get(id.toString());
        // 如果key存在就直接加1
        if (value != null){
            map.put(id.toString(), value+1);
        }else{
            map.put(id.toString(), 1);
        }
        redisService.setCacheMap(key, map);
    }
}
