package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 20:50
 * @description 图片模块
 */
@MapperScan("com.blog.mapper")
@SpringBootApplication
public class PictureApplication {
    public static void main(String[] args) {
        SpringApplication.run(PictureApplication.class, args);
    }
}
