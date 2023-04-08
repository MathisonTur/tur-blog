package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 19:57
 * @description 网站管理模块
 */
@MapperScan("com.blog.mapper")
@EnableFeignClients
@SpringBootApplication
public class WebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }
}
