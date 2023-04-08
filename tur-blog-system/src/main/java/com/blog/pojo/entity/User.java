package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 系统管理-用户基础信息表
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 状态 0:禁用 1:正常
     */
    private Integer status;

    /**
     * 登录方式
     */
    private Integer loginType;

    /**
     * 用户详情id
     */
    private Long userAuthId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * ip来源
     */
    private String ipSource;

    /**
     * 登录系统
     */
    private String os;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 浏览器
     */
    private String browser;


}
