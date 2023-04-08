package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.service.intf.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
}
