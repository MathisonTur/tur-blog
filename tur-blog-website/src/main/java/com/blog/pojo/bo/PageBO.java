package com.blog.pojo.bo;

import lombok.Data;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 20:22
 * @description 网站页面BO
 */
@Data
public class PageBO {
    /**
     * 页面标签
     * */
    private String pageLabel;

    /**
     * 页面封面
     * */
    private String pageCover;
}
