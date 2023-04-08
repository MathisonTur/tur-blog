package com.blog.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 21:28
 * @description 用户信息BO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthBO {

    /**
     * 用户id
     * */
    private Long userAuthId;

    /**
     * 用户昵称
     * */
    private String nickname;

    /**
     * 用户头像
     * */
    private String avatar;

    /**
     * 用户网站
     * */
    private String webSite;
}
