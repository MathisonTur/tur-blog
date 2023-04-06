package com.blog.controller;

import com.blog.pojo.bo.TagBO;
import com.blog.service.intf.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    //============== 供给其他服务的接口 ===============
    @GetMapping("/list/{articleId}")
    public List<TagBO> getTagByArticleId(@PathVariable("articleId") Long articleId){
        return tagService.getTagByArticleId(articleId);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id获取标签")
    TagBO getTagById(@PathVariable("id") Long id){
        return tagService.getTagById(id);
    }
}
