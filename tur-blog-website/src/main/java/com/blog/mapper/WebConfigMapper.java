package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.pojo.entity.WebConfig;

/**
* @author tur
* @description 网站配置表Mapper接口
* @version 1.0
* @date 2023-04-07
*/
public interface WebConfigMapper extends BaseMapper<WebConfig> {

    /**
     * 获取网站信息
     * */
    WebConfig getOne();
}
