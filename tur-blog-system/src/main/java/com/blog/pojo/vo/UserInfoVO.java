package com.blog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/1 13:07
 * @description 前台用户信息封装
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoVO {

    /**
     * 用户账号id
     * */
    private Long id;

    /**
     * 用户信息id
     * */
    private Long userInfoId;

    /**
     * 邮箱号
     * */
    private String email;

    /**
     * 用户名
     * */
    private String username;

    /**
     * 用户昵称
     * */
    private String nickname;

    /**
     * 用户头像
     * */
    private String avatar;

    /**
     * 用户简介
     * */
    private String intro;

    /**
     * 个人网站
     * */
    private String webSite;

    /**
     * 点赞文章集合
     * */
    private Set<Object> articleLikeSet;

    /**
     * 点赞评论集合
     * */
    private Set<Object> commentLikeSet;

    /**
     * 登录方式
     * */
    private Integer loginType;

    /**
     * ip地址
     * */
    private String ipAddress;

    /**
     * ip来源
     * */
    private String ipSource;

    /**
     * 最近登录时间
     * */
    private LocalDateTime lastLoginTime;

    /**
     * token
     * */
    private String token;
}
