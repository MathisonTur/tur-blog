package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.pojo.entity.Comment;

import java.util.List;

/**
* @author tur
* @description 评论表Mapper接口
* @version 1.0
* @date 2023-04-07
*/
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * @description 根据文章id获取评论集合
     * @param articleId 文章id
     * @return java.util.List<com.blog.pojo.entity.CommentBO>
    */
    List<Comment> selectByArticleId(Long articleId);
}
