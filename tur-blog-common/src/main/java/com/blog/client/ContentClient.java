package com.blog.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 19:54
 * @description 内容模块客户端
 */
@FeignClient("content-service")
@Api("内容模块客户端")
public interface ContentClient {

    @GetMapping("/article/selectCount")
    @ApiOperation("查询已发布的文章数量")
    Long selectArticleCount();

    @GetMapping("/category/selectCount")
    @ApiOperation("查询分类数量")
    Long selectCategoryCount();

    @GetMapping("/tag/selectCount")
    @ApiOperation("查询标签数量")
    Long selectTagCount();
}
