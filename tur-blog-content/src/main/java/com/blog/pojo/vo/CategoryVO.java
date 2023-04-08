package com.blog.pojo.vo;

import lombok.Data;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/29 8:34
 * @description 分类封装VO类
 */
@Data
public class CategoryVO {

    /**
     * 分类id
     * */
    private Long id;

    /**
     * 分类名
     * */
    private String name;

    /**
     * 该分类文章数量
     * */
    private Long articleNum;
}
