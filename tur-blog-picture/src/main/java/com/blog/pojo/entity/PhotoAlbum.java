package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 相册
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_photo_album")
public class PhotoAlbum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 相册名
     */
    private String name;

    /**
     * 相册描述
     */
    private String info;

    /**
     * 相册封面
     */
    private String cover;

    /**
     * 状态值 0公开 1私密
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
