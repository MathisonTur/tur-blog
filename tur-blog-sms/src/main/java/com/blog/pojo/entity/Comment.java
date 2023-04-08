package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tur
 * @description 评论表
 * @version 1.0
 * @date 2023-04-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论人ID
     */
    private Long userId;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 内容
     */
    private String content;

    /**
     * 回复人id
     */
    private Long replyUserId;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 评论时间
     */
    private LocalDateTime createTime;


}
