package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.client.CategoryClient;
import com.blog.client.TagClient;
import com.blog.mapper.ArticleMapper;
import com.blog.pojo.entity.Article;
import com.blog.pojo.vo.ArticleListVO;
import com.blog.service.intf.ArticleService;
import com.blog.service.intf.ArticleTagService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    private TagClient tagClient;

    @Resource
    private CategoryClient categoryClient;

    @Resource
    private ArticleTagService articleTagService;

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

    //=========== 自定义方法 =============
    private Page<ArticleListVO> getArticleList(Long pageON, Long pageSize, Long categoryId, Long tagId){
        List<Long> articleId = null;
        if (tagId != null){
            articleId = new ArrayList<>();
            List<Long> finalArticleId = articleId;
            articleTagService.selectByTagId(tagId).forEach(articleTag -> finalArticleId.add(articleTag.getArticleId()));
        }
        Page<Article> articlePage = baseMapper.selectArticleList(new Page<>(pageON, pageSize), PUBLISH.getCode(), articleId, categoryId);
        Page<ArticleListVO> articleVOList = BeanCopyUntils.copyBeanPage(articlePage, ArticleListVO.class);
        articleVOList.getRecords().forEach(articleVO -> {
            articleVO.setTagBOList(tagClient.getTagByArticleId(articleVO.getId()));
            articleVO.setCategoryName(categoryClient.getCategoryById(articleVO.getCategoryId()).getName());
        });
        return articleVOList;
    }
}
