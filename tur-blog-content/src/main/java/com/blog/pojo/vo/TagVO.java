package com.blog.pojo.vo;

import lombok.Data;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/26 20:50
 * @description 标签VO类
 */
@Data
public class TagVO {

    /**
     * 标签id
     * */
    private Long id;

    /**
     * 标签名
     * */
    private String name;
}
