package com.blog.pojo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/8 23:07
 * @description 登录信息
 */
@Data
@ApiModel("登录信息Form")
public class LoginForm {

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("记住我选项")
    private boolean rememberMe;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String username;
}
