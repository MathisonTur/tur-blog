package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author tur
 * @description 网站配置表
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_web_config")
public class WebConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

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
     * 是否开启评论(0:否 1:是)
     */
    private String openComment;

    /**
     * 是否开启赞赏(0:否， 1:是)
     */
    private Boolean openAdmiration;

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
