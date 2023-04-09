package com.blog.controller;

import com.blog.service.intf.UserService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 系统管理-用户基础信息表接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="UserController", tags="系统管理-用户基础信息表业务接口")
public class UserController {

    @Resource
    private UserService  userService;

    @PostMapping("/admin/user/getCurrentUserInfo")
    @ApiOperation("获取当前登录用户信息")
    public ResponseResult getCurrentUserInfo(){
        return userService.getCurrentUserInfo();
    }

    @PostMapping("/admin/user/getUserMenu")
    @ApiOperation("获取用户菜单信息")
    public ResponseResult getUserMenu(){
        return userService.getUserMenu();
    }
}
