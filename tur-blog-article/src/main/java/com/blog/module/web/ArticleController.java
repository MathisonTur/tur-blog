package com.blog.module.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/5 18:33
 * @description 前台文章接口
 */
@RestController
public class ArticleController {

    @GetMapping("/list")
    public String list(){
        return "123";
    }

}
