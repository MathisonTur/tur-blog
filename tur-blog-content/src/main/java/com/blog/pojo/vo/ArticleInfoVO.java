package com.blog.pojo.vo;

import com.blog.pojo.bo.CategoryBO;
import com.blog.pojo.bo.TagBO;
import com.blog.pojo.dto.ArticleLatestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/29 13:52
 * @description 文章详情VO类
 */
@Data
@ApiModel(value = "ArticleInfoVO", description = "文章详情类")
public class ArticleInfoVO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章封面地址")
    private String avatar;

    @ApiModelProperty(value = "文章内容（最多两百字）")
    private String content;

    @ApiModelProperty(value = "文章内容md版")
    private String contentMd;

    @ApiModelProperty(value = "是否是私密文章 0否 1是")
    private Integer isSecret;

    @ApiModelProperty(value = "是否原创 0转载 1原创")
    private Integer isOriginal;

    @ApiModelProperty(value = "转载地址")
    private String originalUrl;

    @ApiModelProperty(value = "文章阅读量")
    private Integer quantity;

    @ApiModelProperty(value = "seo关键词")
    private String keywords;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "文章分类")
    private CategoryBO category;

    // @ApiModelProperty(value = "文章评论集")
    // private List<Comment> comments;

    @ApiModelProperty(value = "文章标签集")
    private List<TagBO> tagBOList;

    @ApiModelProperty(value = "最新文章集")
    private List<ArticleLatestDTO> newestArticleList;

    @ApiModelProperty(value = "上一篇")
    private ArticleLatestDTO lastArticle;

    @ApiModelProperty(value = "下一篇")
    private ArticleLatestDTO nextArticle;

    @ApiModelProperty(value = "文章推荐集")
    private List<ArticleLatestDTO> recommendArticleList;

    @ApiModelProperty(value = "文章点赞量")
    private Integer likeCount;
}
