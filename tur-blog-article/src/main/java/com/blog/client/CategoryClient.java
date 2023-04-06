package com.blog.client;

import com.blog.pojo.bo.CategoryBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 20:34
 * @description 分类客户端
 */
@FeignClient(name = "category-service", path = "/category")
public interface CategoryClient {

    @GetMapping("/{id}")
    CategoryBO getCategoryById(@PathVariable("id") Long id);
}
