package com.blog.service.intf;

import com.blog.pojo.bo.CategoryBO;
import com.blog.pojo.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author tur
 * @description 博客分类表服务
 * @version 1.0
 * @date 2023-04-06
 */
public interface CategoryService extends IService<Category> {

    /**
     * @description 根据分类id获取分类信息
     * @param id 分类id
     * @return com.blog.pojo.bo.CategoryBO
    */
    CategoryBO getCategoryBtId(Long id);
}
