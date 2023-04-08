package com.blog.controller;

import com.blog.pojo.bo.UserAuthBO;
import com.blog.pojo.form.EmailLoginForm;
import com.blog.service.intf.UserAuthService;
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
import javax.validation.Valid;

/**
 * @author tur
 * @description 用户信息表接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="UserAuthController", tags="用户信息表业务接口")
public class UserAuthController {

    @Resource
    private UserAuthService  userAuthService;

    @PostMapping("/web/user/emailLogin")
    @ApiOperation(value = "邮箱登录")
    public ResponseResult emailLogin(@Valid @ApiParam("邮箱登录信息") @RequestBody EmailLoginForm emailLoginForm){
        return userAuthService.emailLogin(emailLoginForm);
    }


    //------------------ 其他服务接口 -----------------
    @GetMapping("/userAuth/{userId}")
    @ApiOperation("根据用户id获取用户信息")
    public UserAuthBO getUserAuthByUserId(Long userId){
        return userAuthService.getUserAuthByUserId(userId);
    }
}
