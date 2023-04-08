package com.blog.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 20:15
 * @description 网站信息DTO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebConfigBO {

    /**
     * logo(文件UID)
     */
    private String logo;

    /**
     * 网站名称
     */
    private String name;

    /**
     * 介绍
     */
    private String summary;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 作者
     */
    private String author;

    /**
     * 备案号
     */
    private String recordNum;

    /**
     * 网站地址
     */
    private String webUrl;

    /**
     * 支付宝收款码FileId
     */
    private String aliPay;

    /**
     * 微信收款码FileId
     */
    private String weixinPay;

    /**
     * github地址
     */
    private String github;

    /**
     * gitee地址
     */
    private String gitee;

    /**
     * QQ号
     */
    private String qqNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 显示的列表（用于控制邮箱、QQ、QQ群、Github、Gitee、微信是否显示在前端）
     */
    private String showList;

    /**
     * 登录方式列表（用于控制前端登录方式，如账号密码,码云,Github,QQ,微信）
     */
    private String loginTypeList;

    /**
     * 游客头像
     */
    private String touristAvatar;

    /**
     * 公告
     */
    private String bulletin;

    /**
     * 作者简介
     */
    private String authorInfo;

    /**
     * 作者头像
     */
    private String authorAvatar;

    /**
     * 关于我
     */
    private String aboutMe;

    /**
     * 是否开启音乐播放器
     */
    private Integer isMusicPlayer;
}
