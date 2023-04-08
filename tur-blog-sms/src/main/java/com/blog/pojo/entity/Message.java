package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 留言表
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * ip位置
     */
    private String ipSource;

    /**
     * 留言移动速度，数字越大，速度越快
     */
    private Integer time;

    /**
     * 状态 0:审核  1：正常
     */
    private Boolean status;


}
