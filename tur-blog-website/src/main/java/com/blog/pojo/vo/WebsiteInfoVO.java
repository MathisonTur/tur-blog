package com.blog.pojo.vo;

import com.blog.pojo.bo.PageBO;
import com.blog.pojo.bo.WebConfigBO;
import com.blog.pojo.dto.ContentCountDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/2 15:23
 * @description 网站信息封装
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteInfoVO {

    /**
     * 网站信息
     * */
    WebConfigBO webSite;

    /**
     * 页面信息
     * */
    List<PageBO> pageList;

    /**
     * 内容点击量
     * */
    ContentCountDTO count;
}
