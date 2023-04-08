package com.blog.pojo.vo;

import com.blog.pojo.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/2 13:14
 * @description 评论信息封装
 */
@Data
@AllArgsConstructor
public class CommentVO {

    /**
     * 评论数量
     * */
    Long commentCount;

    /**
     * 评论信息
     * */
    List<CommentDTO> commentDTOList;
}
