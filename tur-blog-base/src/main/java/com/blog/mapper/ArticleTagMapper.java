package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.pojo.entity.ArticleTag;

import java.util.List;

/**
* @author tur
* @description Mapper接口
* @version 1.0
* @date 2023-04-06
*/
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    /**
     * @description 根据标签id获取文章id
     * @param tagId 标签id
     * @return com.blog.pojo.entity.ArticleTag
     */
    List<ArticleTag> selectByTagId(Long tagId);

    /**
     * @param articleId 文章id
     * @return com.blog.pojo.entity.ArticleTag
     * @description 根据文章id查询标签id
     */
    List<ArticleTag> selectByArticleId(Long articleId);

}
