package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 20:17
 * @description 分类模块
 */
@MapperScan("com.blog.mapper")
@SpringBootApplication
public class CategoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class, args);
    }
}
