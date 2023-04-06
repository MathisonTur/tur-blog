package com.blog.controller;

import com.blog.pojo.bo.CategoryBO;
import com.blog.service.intf.CategoryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 博客分类表接口
 * @version 1.0
 * @date 2023-04-06
 */
@Slf4j
@RestController
@Api(value="CategoryController", tags="博客分类表业务接口")
public class CategoryController {

    @Resource
    private CategoryService  categoryService;

    @GetMapping("/{id}")
    public CategoryBO getCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryBtId(id);
    }
}
