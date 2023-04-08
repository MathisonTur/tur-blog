package com.blog.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 22:32
 * @description 最新文章类
 */
@Data
public class ArticleLatestDTO {

    /**
     * id
     * */
    private Long id;

    /**
     * 文章标题
     * */
    private String title;

    /**
     * 文章封面地址
     * */
    private String avatar;

    /**
     * 创建时间
     * */
    private LocalDateTime createTime;
}
