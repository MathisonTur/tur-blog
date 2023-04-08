package com.blog.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 20:03
 * @description 文章标签分类点击量和网站访问量
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentCountDTO {

    /**
     * 文章阅读量
     * */
    private Long articleCount;

    /**
     * 分类点击量
     * */
    private Long categoryCount;

    /**
     * 标签点击量
     * */
    private Long tagCount;

    /**
     * 网站访问量
     * */
    private String viewsCount;
}
