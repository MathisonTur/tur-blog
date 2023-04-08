package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author tur
 * @description 友情链接表
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@TableName("t_friend_link")
public class FriendLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 网站名称
     */
    private String name;

    /**
     * 网站地址
     */
    private String url;

    /**
     * 网站头像地址
     */
    private String avatar;

    /**
     * 网站描述
     */
    private String info;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 下架原因
     */
    private String reason;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * ENUM-状态:"0-待审核","1-通过"
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
