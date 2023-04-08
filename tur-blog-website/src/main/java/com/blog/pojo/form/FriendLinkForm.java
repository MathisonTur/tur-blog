package com.blog.pojo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 17:13
 * @description 友链信息Form
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("友链VO类")
public class FriendLinkForm {
    @ApiModelProperty(value = "网站名称")
    private String name;

    @ApiModelProperty(value = "网站地址")
    private String url;

    @ApiModelProperty(value = "网站头像地址")
    private String avatar;

    @ApiModelProperty(value = "网站描述")
    private String info;

    @ApiModelProperty(value = "邮箱")
    private String email;
}
