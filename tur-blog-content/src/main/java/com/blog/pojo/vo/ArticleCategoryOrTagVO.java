package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/28 9:16
 * @description 分类or标签文章类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ArticleCategoryOrTagVO",description = "分类or标签文章类")
public class ArticleCategoryOrTagVO {

    /**
     * 文章记录列表
     */
    private List<ArticleListVO> records;

    /**
     * 分类or标签
     * */
    private String name;
}
