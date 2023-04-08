package com.blog.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 21:20
 * @description 评论BO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentBO {

    /**
     * ID
     */
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
