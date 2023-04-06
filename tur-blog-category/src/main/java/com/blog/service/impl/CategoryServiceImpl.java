package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.CategoryMapper;
import com.blog.pojo.bo.CategoryBO;
import com.blog.pojo.entity.Category;
import com.blog.service.intf.CategoryService;
import com.blog.util.BeanCopyUntils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author tur
* @description 博客分类表服务
* @version 1.0
* @date 2023-04-06
*/
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * @param id 分类id
     * @return com.blog.pojo.bo.CategoryBO
     * @description 根据分类id获取分类信息
     */
    @Override
    public CategoryBO getCategoryBtId(Long id) {
        return BeanCopyUntils.copyBean(baseMapper.selectById(id), CategoryBO.class);
    }
}
