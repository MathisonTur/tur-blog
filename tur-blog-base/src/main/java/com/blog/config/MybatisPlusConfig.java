package com.blog.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 20:05
 * @description mybatis-plus配置
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        // 1. 创建 MybatisPlusInterceptor 拦截器对象
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        // 2. 添加分页拦截器，并声明使用的数据库类型
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mpInterceptor;
    }
}
