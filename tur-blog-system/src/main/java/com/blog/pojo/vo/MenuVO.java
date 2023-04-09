package com.blog.pojo.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/9 17:27
 * @description 用户菜单信息VO
 */
@Data
@Builder
public class MenuVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 上级资源ID
     */
    private String parentId;

    /**
     * url
     */
    private String url;

    /**
     * 资源编码
     */
    private String component;

    /**
     * 资源名称
     */
    private String title;

    /**
     * 资源级别
     */
    private Integer level;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 类型 menu、button
     */
    private String type;

    /**
     * 跳转地址
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否隐藏
     * */
    private String hidden;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 子菜单
     * */
    List<MenuVO> children;
}
