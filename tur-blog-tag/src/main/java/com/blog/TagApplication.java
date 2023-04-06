package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 19:16
 * @description 标签模块
 */
@SpringBootApplication
@MapperScan("com.blog.mapper")
public class TagApplication {
    public static void main(String[] args) {
        SpringApplication.run(TagApplication.class, args);
    }
}
