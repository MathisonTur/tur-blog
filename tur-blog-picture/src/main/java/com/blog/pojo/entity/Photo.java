package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 照片
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_photo")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 相册id
     */
    private Integer albumId;

    /**
     * 照片名
     */
    private String name;

    /**
     * 照片描述
     */
    private String info;

    /**
     * 照片地址
     */
    private String url;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
