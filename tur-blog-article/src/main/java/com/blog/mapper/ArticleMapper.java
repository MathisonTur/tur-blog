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

}
