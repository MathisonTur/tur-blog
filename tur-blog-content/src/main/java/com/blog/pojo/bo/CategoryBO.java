package com.blog.pojo.bo;

import lombok.Data;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 20:29
 * @description 分类数据
 */
@Data
public class CategoryBO {
    /**
     * 分类id
     * */
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 该分类文章数量
     */
    private Long articleNum;
}
