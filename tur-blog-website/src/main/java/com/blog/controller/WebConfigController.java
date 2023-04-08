package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.service.intf.WebConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * @author tur
 * @description 网站配置表接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="WebConfigController", tags="网站配置表业务接口")
public class WebConfigController {

    @Resource
    private WebConfigService  webConfigService;
}
