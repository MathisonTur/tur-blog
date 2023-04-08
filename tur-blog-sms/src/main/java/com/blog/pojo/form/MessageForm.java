package com.blog.pojo.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 21:00
 * @description 消息Form
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageForm {
    /**
     * 内容
     * */
    private String content;

    /**
     * 用户昵称
     * */
    private String nickname;

    /**
     * 用户头像
     * */
    private String avatar;

    /**
     * 弹幕移动速度，默认7
     * */
    private Integer time;
}
