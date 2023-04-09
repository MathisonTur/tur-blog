package com.blog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/5 9:49
 * @description 后台用户登录信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    /**
     * 用户id
     * */
    private Long id;

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
     * 用户状态.0:禁用。1：正常
     * */
    private Integer status;

    /**
     * 用户角色id
     * */
    private Long roleId;
}
