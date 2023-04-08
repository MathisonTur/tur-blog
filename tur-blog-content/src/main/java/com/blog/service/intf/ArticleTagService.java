package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.entity.ArticleTag;

import java.util.List;

/**
 * @author tur
 * @description 服务
 * @version 1.0
 * @date 2023-04-06
 */
public interface ArticleTagService extends IService<ArticleTag> {

    /**
     * @description 根据标签id获取文章标签关联
     * @param tagId 标签id
     * @return com.blog.model.entity.ArticleTag
     */
    List<ArticleTag> selectByTagId(Long tagId);

    /**
     * @description 根据文章id查询标签id
     * @param articleId 文章id
     * @return com.blog.model.entity.ArticleTag
     */
    List<ArticleTag> selectByArticleId(Long articleId);
}
