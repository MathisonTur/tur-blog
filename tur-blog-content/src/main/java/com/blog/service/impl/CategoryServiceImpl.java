package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.CategoryMapper;
import com.blog.pojo.bo.CategoryBO;
import com.blog.pojo.entity.Category;
import com.blog.pojo.vo.CategoryVO;
import com.blog.service.intf.ArticleService;
import com.blog.service.intf.CategoryService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author tur
* @description 博客分类表服务
* @version 1.0
* @date 2023-04-06
*/
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Lazy
    @Resource
    ArticleService articleService;

    //======================= web方法 ======================
    /**
     * @return java.util.List<com.blog.model.vo.CategoryVO>
     * @author tur
     * @date 2023/3/29 8:37
     * @description 获取分类列表
     */
    @Override
    public ResponseResult getCategoryList() {
        List<CategoryVO> categoryVOList = BeanCopyUntils.copyBeanList(list(), CategoryVO.class);
        categoryVOList.forEach(categoryVO -> categoryVO.setArticleNum(articleService.selectByCategoryId(categoryVO.getId())));
        return ResponseResult.success(categoryVOList);
    }

    /**
     * @param id 分类id
     * @return com.blog.service.intf.pojo.bo.CategoryBO
     * @description 根据分类id获取分类信息
     */
    @Override
    public CategoryBO getCategoryById(Long id) {
        return BeanCopyUntils.copyBean(baseMapper.selectById(id), CategoryBO.class);
    }

    //===================== 其他服务方法 =========================
    /**
     * @return java.lang.Long
     * @description 查询分类数量
     */
    @Override
    public Long selectCount() {
        return baseMapper.selectCount(null);
    }
}
