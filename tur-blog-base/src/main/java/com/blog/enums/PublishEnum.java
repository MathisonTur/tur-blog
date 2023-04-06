package com.blog.enums;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/27 8:47
 * @description 文章发布状态枚举类
 */
public enum PublishEnum {
    /**
     * 文章下架
     * */
    SHELF(0),

    /**
     * 文章发布
     * */
    PUBLISH(1);
    private int code;

    PublishEnum(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
