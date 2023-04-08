package com.blog.controller;

import com.blog.service.intf.TagService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 博客标签表接口
 * @version 1.0
 * @date 2023-04-06
 */
@Slf4j
@RestController
@Api(value="TagController", tags="博客标签表业务接口")
public class TagController {

    @Resource
    private TagService  tagService;

    @GetMapping("/web/tags/list")
    @ApiOperation(value = "标签列表")
    public ResponseResult getTagList(){
        return tagService.getTagList();
    }

    //========================= 其他服务接口 ==================================
    @GetMapping("/tag/selectCount")
    @ApiOperation("查询标签数量")
    public Long selectCount(){
        return tagService.selectCount();
    }
}
