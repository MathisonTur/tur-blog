package com.blog.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/26 22:40
 * @description Bean拷贝封装
 */
public class BeanCopyUntils {

    /**
     * @author tur
     * @date 2023/3/26 22:45
     * @description 实现单个拷贝
     * @param source 被拷贝的对象
     * @param clazz 拷贝生成的对象的类
     * @return T
    */
    public static <T> T copyBean(Object source, Class<T> clazz){
        // 创建目标对象
        T result = null;
        try {
            result = clazz.getDeclaredConstructor().newInstance();
            // 进行拷贝
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回结果
        return result;
    }

    /**
     * @author tur
     * @date 2023/3/26 22:46
     * @description 批量拷贝
     * @param list 被拷贝的对象数组
     * @param clazz 生成的对象的类
     * @return java.util.List<V> 返回生成的对象的数组
    */
    public static <O, V> List<V> copyBeanList(List<O> list, Class<V> clazz){
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }

    /**
     * @description 页面拷贝
     * @param page 页面
     * @param clazz 类别
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<V>
    */
    public static <O, V> Page<V> copyBeanPage(Page<O> page, Class<V> clazz){
        Page<V> newPage = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        newPage.setPages(page.getPages());
        newPage.setRecords(copyBeanList(page.getRecords(), clazz));
        return newPage;
    }
}
