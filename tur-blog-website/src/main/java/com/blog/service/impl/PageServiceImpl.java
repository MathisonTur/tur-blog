package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.PageMapper;
import com.blog.pojo.bo.PageBO;
import com.blog.pojo.entity.Page;
import com.blog.service.intf.PageService;
import com.blog.util.BeanCopyUntils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author tur
* @description 页面信息服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {

    /**
     * @return java.util.List<com.blog.pojo.bo.PageBO>
     * @description 获取网站页面信息
     */
    @Override
    public List<PageBO> getList() {
        return BeanCopyUntils.copyBeanList(baseMapper.getList(), PageBO.class);
    }
}
