package com.blog.controller;

import com.blog.service.intf.HomeService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/2 15:00
 * @description 前台首页接口
 */
@RestController
@Api(value = "HomeController", tags = "前台门户首页接口")
public class HomeController {

    @Resource
    private HomeService homeService;

    @GetMapping("/web/home/webSiteInfo")
    @ApiOperation("网站信息")
    public ResponseResult webSiteInfo(){
        return homeService.webSiteInfo();
    }

    @GetMapping("/web/home/report")
    @ApiOperation("增加访问量")
    public ResponseResult report(@ApiParam("前端请求") HttpServletRequest request){
        return homeService.report(request);
    }
}
