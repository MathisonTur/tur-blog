package com.blog.controller;

import com.blog.client.WebsiteClient;
import com.blog.pojo.form.LoginForm;
import com.blog.service.intf.LoginService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/4 22:34
 * @description 后台登录接口
 */
@Slf4j
@RestController
@Api("后台登录接口")
public class LoginController {

    @Resource
    LoginService loginService;

    @Resource
    WebsiteClient websiteClient;

    @PostMapping("/admin/login")
    @ApiOperation("后台登录")
    public ResponseResult login(@ApiParam("登录信息") @RequestBody LoginForm loginForm){
        return loginService.login(loginForm);
    }

    @GetMapping("/admin/logout")
    @ApiOperation("退出登录")
    public ResponseResult logout(){
        return loginService.logout();
    }

    @GetMapping("/admin/report")
    @ApiOperation("增加访问量")
    public ResponseResult report(@ApiParam("前端请求") HttpServletRequest request){
        return websiteClient.report(request);
    }
}
