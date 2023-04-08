package com.blog.enums;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/3 22:43
 * @description 是否常量枚举
 */
public enum YesOrNoEnum {
    NO (0, "否"),

    YES (1, "是");

    //创建构造函数
    YesOrNoEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //定义私有方法，获取枚举值
    private final Integer code;
    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
