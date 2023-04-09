package com.blog.client;

import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/9 8:52
 * @description 网站模块客户端
 */
@FeignClient("website-service")
@Api("网站模块客户端")
public interface WebsiteClient {

    @GetMapping("/web/home/report")
    @ApiOperation("增加网站访问量")
    ResponseResult report(@ApiParam("前端请求") HttpServletRequest request);
}
