package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.service.intf.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * @author tur
 * @description 系统管理-权限资源表 接口
 * @version 1.0
 * @date 2023-04-09
 */
@Slf4j
@RestController
@Api(value="MenuController", tags="系统管理-权限资源表 业务接口")
public class MenuController {

    @Resource
    private MenuService  menuService;
}
