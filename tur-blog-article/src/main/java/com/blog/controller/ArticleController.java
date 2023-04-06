package com.blog.controller;

import com.blog.service.intf.ArticleService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 博客文章表接口
 * @version 1.0
 * @date 2023-04-06
 */
@Slf4j
@RestController
@Api(value="ArticleController", tags="博客文章表业务接口")
public class ArticleController {

    @Resource
    private ArticleService  articleService;

    @GetMapping("/list")
    @ApiOperation("文章列表")
    public ResponseResult getArticleList(
            @ApiParam(value = "页码") @RequestParam Long pageNo,
            @ApiParam(value = "每页数量") @RequestParam Long pageSize
    ){
        return articleService.getArticlePage(pageNo, pageSize);
    }

    @GetMapping("/condition")
    @ApiOperation(value = "分类标签文章列表查询")
    public ResponseResult condition(
            @ApiParam(value = "分类id") @RequestParam(required = false) Long categoryId,
            @ApiParam(value = "标签id") @RequestParam(required = false) Long tagId,
            @ApiParam(value = "页码") @RequestParam Long pageNo,
            @ApiParam(value = "每页数量") @RequestParam Long pageSize){
        return articleService.condition(categoryId, tagId, pageNo, pageSize);
    }

    @GetMapping("/archive")
    @ApiOperation(value = "文章归档")
    public ResponseResult archive(
            @ApiParam(value = "页码") @RequestParam Long pageNo,
            @ApiParam(value = "每页数量") @RequestParam Long pageSize){
        return articleService.getArticlePage(pageNo, pageSize);
    }

    @GetMapping("/info")
    @ApiOperation(value = "文章详情")
    public ResponseResult articleInfo(@ApiParam(value = "文章id") @RequestParam Long id){
        return articleService.articleInfo(id);
    }

    @GetMapping("/articleLike")
    @ApiOperation(value = "文章点赞")
    public ResponseResult articleLike(@ApiParam(value = "文章id")  @RequestParam Long articleId){
        return articleService.articleLike(articleId);
    }

    @GetMapping("/checkSecret")
    @ApiOperation(value = "文章验证秘钥")
    public ResponseResult checkSecret(@ApiParam("验证码") String code){
        return articleService.checkSecret(code);
    }
}
