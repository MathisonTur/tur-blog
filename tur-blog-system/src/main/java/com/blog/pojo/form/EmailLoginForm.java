package com.blog.pojo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 15:45
 * @description 邮箱登录信息
 */
@Data
@ApiModel(description = "邮箱登录信息")
public class EmailLoginForm {

    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty("邮箱")
    private String email;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;
}
