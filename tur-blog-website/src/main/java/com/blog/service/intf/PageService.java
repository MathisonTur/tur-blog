package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.bo.PageBO;
import com.blog.pojo.entity.Page;

import java.util.List;

/**
 * @author tur
 * @description 页面信息服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface PageService extends IService<Page> {

    /**
     * @description 获取网站页面信息
     * @return java.util.List<com.blog.pojo.bo.PageBO>
    */
    List<PageBO> getList();
}
