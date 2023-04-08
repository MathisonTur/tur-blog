package com.blog.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 16:29
 * @description 向其他服务提供Tag数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("标签数据")
public class TagBO {

    @ApiModelProperty("标签id")
    private Long id;

    @ApiModelProperty("标签名")
    private String name;
}
