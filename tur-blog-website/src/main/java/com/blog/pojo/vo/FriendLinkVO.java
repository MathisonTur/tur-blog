package com.blog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 17:13
 * @description 友链信息VO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendLinkVO {

    /**
     * 友链名称
     * */
    private String name;

    /**
     * 网站地址
     * */
    private String url;

    /**
     * 友链头像
     * */
    private String avatar;

    /**
     * 网站简介
     * */
    private String info;

    /**
     * 邮箱
     * */
    private String email;
}
