package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.service.intf.RoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * @author tur
 * @description 系统管理 - 角色-权限资源关联表 接口
 * @version 1.0
 * @date 2023-04-09
 */
@Slf4j
@RestController
@Api(value="RoleMenuController", tags="系统管理 - 角色-权限资源关联表 业务接口")
public class RoleMenuController {

    @Resource
    private RoleMenuService  roleMenuService;
}
