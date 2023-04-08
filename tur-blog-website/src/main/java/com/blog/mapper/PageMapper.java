package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.pojo.entity.Page;

import java.util.List;

/**
* @author tur
* @description 页面信息Mapper接口
* @version 1.0
* @date 2023-04-07
*/
public interface PageMapper extends BaseMapper<Page> {

    /**
     * @description 获取网站信息
     * @return com.blog.pojo.entity.Page
    */
    List<Page> getList();
}
