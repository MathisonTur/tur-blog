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
}
