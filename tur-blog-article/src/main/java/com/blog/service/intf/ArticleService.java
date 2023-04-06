package com.blog.service.intf;

import com.blog.pojo.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 博客文章表服务
 * @version 1.0
 * @date 2023-04-06
 */
public interface ArticleService extends IService<Article> {

    /**
     * @description 分页获取文章列表
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return com.blog.util.ResponseResult
    */
    ResponseResult getArticlePage(Long pageNo, Long pageSize);

    /**
     * @description 分类or标签文章列表
     * @param categoryId 分类id
     * @param tagId 标签id
     * @param pageSize 每页数量
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult condition(Long categoryId, Long tagId, Long pageNo, Long pageSize);

    /**
     * @description 根据文章id获取文章详情
     * @param id 文章id
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult articleInfo(Long id);

    /**
     * @description 文章点赞
     * @param id 文章id
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult articleLike(Long id);

    /**
     * @description 根据分类id获取文章数量
     * @param categoryId 分类id
     * @return java.util.List<com.blog.model.vo.ArticleVO>
     */
    Long selectByCategoryId(Long categoryId);

    /**
     * @description 校验密钥
     * @param code 验证码
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult checkSecret(String code);
}
