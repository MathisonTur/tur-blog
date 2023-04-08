package com.blog.controller;

import com.blog.service.intf.CategoryService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/web/category/list")
    @ApiOperation(value = "分列列表")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

    //============================== 其他服务方法 ===============================
    @GetMapping("/category/selectCount")
    @ApiOperation("查询分类数量")
    public Long selectCount(){
        return categoryService.selectCount();
    }
}
