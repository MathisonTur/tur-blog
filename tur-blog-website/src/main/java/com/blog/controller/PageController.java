package com.blog.controller;

import com.blog.service.intf.PageService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 页面信息接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="PageController", tags="页面信息业务接口")
public class PageController {

    @Resource
    private PageService  pageService;
}
