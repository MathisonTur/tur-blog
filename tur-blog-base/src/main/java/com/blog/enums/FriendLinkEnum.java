package com.blog.enums;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/3 21:12
 * @description 友链状态枚举类
 */
public enum FriendLinkEnum {

    /**
     * 下架
     * */
    DOWN(0, "下架"),

    /**
     * 友链申请
     * */
    APPLY(1, "申请"),

    /**
     * 友链上架
     * */
    UP(2, "上架");

    private final Integer code;
    private final String message;

    FriendLinkEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
