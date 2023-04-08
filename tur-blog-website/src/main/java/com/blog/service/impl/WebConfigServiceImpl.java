package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.WebConfigMapper;
import com.blog.pojo.bo.WebConfigBO;
import com.blog.pojo.entity.WebConfig;
import com.blog.service.intf.WebConfigService;
import com.blog.util.BeanCopyUntils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author tur
* @description 网站配置表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class WebConfigServiceImpl extends ServiceImpl<WebConfigMapper, WebConfig> implements WebConfigService {

    /**
     * @return com.blog.pojo.entity.WebConfig
     * @description 获取网站信息
     */
    @Override
    public WebConfigBO getOne() {
        return BeanCopyUntils.copyBean(baseMapper.getOne(), WebConfigBO.class);
    }
}
