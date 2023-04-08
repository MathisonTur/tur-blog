package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.bo.UserAuthBO;
import com.blog.pojo.entity.UserAuth;
import com.blog.pojo.form.EmailLoginForm;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 用户信息表服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface UserAuthService extends IService<UserAuth> {

    /**
     * @description 邮箱登录
     * @param emailLoginForm 邮箱登录信息
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult emailLogin(EmailLoginForm emailLoginForm);

    /**
     * @description 根据用户id获取用户信息
     * @param userId 用户id
     * @return com.blog.pojo.bo.UserAuthBO
    */
    UserAuthBO getUserAuthByUserId(Long userId);
}
