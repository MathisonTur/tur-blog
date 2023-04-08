package com.blog.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Objects;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/27 7:14
 * @description 分页工具类
 */
public class PageUtils {

    private static final ThreadLocal<Page<?>> PAGE_HOLDER = new ThreadLocal<>();

    public static void setCurrentPage(Page<?> page){
        PAGE_HOLDER.set(page);
    }

    public static Page<?> getPage(){
        Page<?> page = PAGE_HOLDER.get();
        if (Objects.isNull(page)){
            setCurrentPage(new Page<>());
        }
        return PAGE_HOLDER.get();
    }

    public static Long getPageON(){
        return getPage().getCurrent();
    }

    public static Long getPageSize(){
        return getPage().getSize();
    }

    public static Long getLimitCurrent(){
        return (getPageON() - 1) * getPageSize();
    }

    public static void remove(){
        PAGE_HOLDER.remove();
    }
}
