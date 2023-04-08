package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 博客文章表
 * @version 1.0
 * @date 2023-04-06
 */
@Data
@TableName("t_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章封面地址
     */
    private String avatar;

    /**
     * 文章简介
     */
    private String summary;

    /**
     * 文章内容 （最多两百字）
     */
    private String content;

    /**
     * 文章内容md版
     */
    private String contentMd;

    /**
     * 是否是私密文章 0 否 1是
     */
    private Integer isSecret;

    /**
     * 是否置顶 0否 1是
     */
    private Integer isStick;

    /**
     * 是否发布 0：下架 1：发布
     */
    private Integer isPublish;

    /**
     * 是否原创  0：转载 1:原创
     */
    private Integer isOriginal;

    /**
     * 转载地址
     */
    private String originalUrl;

    /**
     * 文章阅读量
     */
    private Long quantity;

    /**
     * 说明
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * seo关键词
     */
    private String keywords;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
