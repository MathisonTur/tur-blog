package com.blog.controller;

import com.blog.pojo.form.CommentForm;
import com.blog.service.intf.CommentService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 评论表接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="CommentController", tags="评论表业务接口")
public class CommentController {

    @Resource
    private CommentService  commentService;

    //========================== web 方法 ===========================
    @GetMapping("/comments")
    @ApiOperation("查询文章评论")
    public ResponseResult comments(
            @ApiParam("文章id") @RequestParam Long articleId,
            @ApiParam("页码") @RequestParam Long pageNo,
            @ApiParam("每页数量") @RequestParam Long pageSize
    ){
        return commentService.comments(articleId, pageNo, pageSize);
    }

    @PostMapping("/addComment")
    @ApiOperation("添加评论")
    public ResponseResult addComment(@ApiParam("评论添加信息") @RequestBody CommentForm commentForm){
        return commentService.addComment(commentForm);
    }

    @GetMapping("/repliesByComId")
    @ApiOperation("查询评论回复")
    public ResponseResult repliesByCommentId(@ApiParam("评论id") @RequestParam Long commentId){
        return commentService.repliesByCommentId(commentId);
    }
}
