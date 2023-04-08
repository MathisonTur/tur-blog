package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.pojo.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author tur
* @description 博客文章表Mapper接口
* @version 1.0
* @date 2023-04-06
*/
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * @description 查询分页文章列表
     * @param page 分页对象
     * @param publish 是否发布
     * @param idList 文章id列表
     * @param categoryId 分类id
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.blog.model.entity.Article>
     */
    Page<Article> selectArticleList(
            @Param("page") Page<Article> page,
            @Param("publish") Integer publish,
            @Param("idList") List<Long> idList,
            @Param("categoryId") Long categoryId);

    /**
     * @description 根据文章id，获取其他最新的五篇文章
     * @param id 文章id
     * @param publish 发布状态
     * @return java.util.List<com.blog.model.entity.Article>
     */
    List<Article> getNewestArticleList(@Param("id") Long id, @Param("publish") Integer publish);

    /**
     * @description 根据文章id，获取该文章的上一篇或下一篇
     * @param id 文章id
     * @param publish 发布状态
     * @param type 0：上一篇还；1：下一篇
     * @return com.blog.model.entity.Article
     */
    Article getLastOrNextArticle(@Param("id") Long id, @Param("publish") Integer publish, @Param("type") Integer type);

    /**
     * @description 文章推荐
     * @param articleId 文章id
     * @return java.util.List<com.blog.model.entity.Article>
     */
    List<Article> getRecommendArticleList(Long articleId);



    //=========== 供给其他服务方法 ==============
    /**
     * @description 根据分类id获取文章数量
     * @param categoryId 分类id
     * @return java.lang.Long
     */
    Long selectByCategoryId(@Param("categoryId") Long categoryId, @Param("publish") Integer publish);

    /**
     * @description 查询已发布的文章数量
     * @return java.lang.Long
    */
    Long selectCount(int publish);
}
