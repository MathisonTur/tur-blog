package com.blog.service.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.constant.SQLConstant;
import com.blog.enums.ResponseCodeEnum;
import com.blog.pojo.entity.User;
import com.blog.pojo.form.LoginForm;
import com.blog.service.intf.LoginService;
import com.blog.service.intf.UserService;
import com.blog.util.AesEncryptUtils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/4 22:44
 * @description 后台登录服务
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserService userService;

    /**
     * @param loginForm 登录信息
     * @return com.blog.utils.ResponseResult 验证成功后，data携带token
     * @description 后台登录
     */
    @Override
    public ResponseResult login(LoginForm loginForm) {
        // 以登录信息获取数据库中的用户信息
        User user = userService.getOne(new QueryWrapper<User>()
                .eq(SQLConstant.USERNAME, loginForm.getUsername())
                .eq(SQLConstant.PASSWORD, AesEncryptUtils.aesEncrypt(loginForm.getPassword()))
        );
        // 判断数据库中是否存在用户，不存在则直接抛出异常
        Assert.isTrue(user != null, ResponseCodeEnum.ERROR_PASSWORD.getMsg());

        if (loginForm.isRememberMe()){
            // 勾选了记住我选项，保存登录信息一周
            StpUtil.login(user.getId(),new SaLoginModel().setTimeout(60 * 60 * 24 * 7));
        } else {
            // 没有勾选，直接进行登录
            StpUtil.login(user.getId());
        }

        // 登录成功，返回数据中添加token
        return ResponseResult.success(StpUtil.getTokenValue());
    }

    /**
     * @return com.blog.utils.ResponseResult 退出登录，仅返回状态码与信息
     * @description 退出登录
     */
    @Override
    public ResponseResult logout() {
        return null;
    }
}
