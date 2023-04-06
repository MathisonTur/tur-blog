package com.blog.pojo.vo;

import com.blog.pojo.bo.TagBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 19:25
 * @description 文章列表VO类
 */
@Data
@ApiModel("文章VO类")
public class ArticleListVO {
    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "分类名")
    private String categoryName;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章封面地址")
    private String avatar;

    @ApiModelProperty(value = "文章内容md版")
    private String contentMd;

    @ApiModelProperty(value = "是否置顶 0否 1是")
    private Integer isStick;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "标签表")
    private List<TagBO> tagBOList;
}
