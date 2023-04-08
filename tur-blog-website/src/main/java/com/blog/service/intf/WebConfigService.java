package com.blog.service.intf;

import com.blog.pojo.bo.WebConfigBO;
import com.blog.pojo.entity.WebConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author tur
 * @description 网站配置表服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface WebConfigService extends IService<WebConfig> {

    /**
     * @description 获取网站信息
     * @return com.blog.pojo.entity.WebConfig
    */
    WebConfigBO getOne();
}
