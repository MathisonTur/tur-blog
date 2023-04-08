package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.bo.CategoryBO;
import com.blog.pojo.entity.Category;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 博客分类表服务
 * @version 1.0
 * @date 2023-04-06
 */
public interface CategoryService extends IService<Category> {

    //======== 接口调用 ===========
    /**
     * @description 获取分类列表
     * @return java.util.List<com.blog.model.vo.CategoryVO>
     */
    ResponseResult getCategoryList();

    //======== 其他服务调用 ========
    /**
     * @description 根据分类id获取分类信息
     * @param id 分类id
     * @return com.blog.service.intf.pojo.bo.CategoryBO
    */
    CategoryBO getCategoryById(Long id);

    //======================== 其他服务方法 ==============================
    /**
     * @description 查询分类数量
     * @return java.lang.Long
     */
    Long selectCount();
}
