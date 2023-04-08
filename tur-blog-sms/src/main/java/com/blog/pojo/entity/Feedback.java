package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 反馈表
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_feedback")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 标题
     */
    private String title;

    /**
     * 详细内容
     */
    private String content;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 反馈类型 0:需求 1：缺陷
     */
    private Boolean type;


}
