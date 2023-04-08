package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 页面信息
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_page")
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     * */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 页面名
     * */
    private String pageName;

    /**
     * 页面标签
     * */
    private String pageLabel;

    /**
     * 页面封面
     * */
    private String pageCover;

    /**
     * 创建时间
     * */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * */
    private LocalDateTime updateTime;


}
