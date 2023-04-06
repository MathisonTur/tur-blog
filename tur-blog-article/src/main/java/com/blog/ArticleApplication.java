package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/5 18:13
 * @description 文章模块
 */
@SpringBootApplication
@MapperScan("com.blog")
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
