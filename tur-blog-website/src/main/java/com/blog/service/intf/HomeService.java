package com.blog.service.intf;

import com.blog.util.ResponseResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/2 18:47
 * @description 首页服务类
 */
public interface HomeService {

    /**
     * @return com.blog.utils.ResponseResult
     * @author tur
     * @date 2023/4/2 15:05
     * @description 获取站点信息
     */
    ResponseResult webSiteInfo();

    /**
     * @author tur
     * @date 2023/4/2 18:51
     * @description 增加访问量
     * @param request 前端请求
     * @return com.blog.utils.ResponseResult
    */
    ResponseResult report(HttpServletRequest request);
}
