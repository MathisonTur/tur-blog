package com.blog.service.intf;

import com.blog.pojo.form.LoginForm;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/4 22:42
 * @description 后台登录服务
 */
public interface LoginService {

    /**
     * @description 后台登录
     * @param loginForm 登录信息
     * @return com.blog.utils.ResponseResult 验证成功后，data携带token
    */
    ResponseResult login(LoginForm loginForm);

    /**
     * @description 退出登录
     * @return com.blog.utils.ResponseResult 退出登录，仅返回状态码与信息
    */
    ResponseResult logout();
}
