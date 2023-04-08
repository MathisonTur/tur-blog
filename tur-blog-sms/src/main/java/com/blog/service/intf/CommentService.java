package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.bo.CommentBO;
import com.blog.pojo.entity.Comment;
import com.blog.pojo.form.CommentForm;
import com.blog.util.ResponseResult;

import java.util.List;

/**
 * @author tur
 * @description 评论表服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface CommentService extends IService<Comment> {

    /**
     * @description 获取文章评论
     * @param articleId 文章ID
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult comments(Long articleId, Long pageNo, Long pageSize);

    /**
     * @description 添加评论
     * @param commentForm 评论信息
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult addComment(CommentForm commentForm);

    /**
     * @description 查询评论回复
     * @param commentId 评论id
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult repliesByCommentId(Long commentId);

    //--------------- 其他服务方法 ----------------
    /**
     * @description 根据文章id获取评论集合
     * @param articleId 文章id
     * @return java.util.List<com.blog.model.entity.CommentBO>
     */
    List<CommentBO> selectByArticleId(Long articleId);
}
