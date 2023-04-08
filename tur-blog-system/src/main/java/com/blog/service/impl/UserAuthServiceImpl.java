package com.blog.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.SQLConstant;
import com.blog.enums.ResponseCodeEnum;
import com.blog.exception.BusinessException;
import com.blog.mapper.UserAuthMapper;
import com.blog.pojo.bo.UserAuthBO;
import com.blog.pojo.entity.User;
import com.blog.pojo.entity.UserAuth;
import com.blog.pojo.form.EmailLoginForm;
import com.blog.pojo.vo.UserInfoVO;
import com.blog.service.intf.UserAuthService;
import com.blog.service.intf.UserService;
import com.blog.util.AesEncryptUtils;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
* @author tur
* @description 用户信息表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements UserAuthService {

    @Resource
    UserService userService;

    /**
     * @param emailLoginForm 邮箱登录信息
     * @return com.blog.utils.ResponseResult
     * @description 邮箱登录
     */
    @Override
    public ResponseResult emailLogin(EmailLoginForm emailLoginForm) {
        if (emailLoginForm == null){
            throw new BusinessException(ResponseCodeEnum.ERROR.getMsg());
        }
        // 检查邮箱格式
        checkEmail(emailLoginForm.getEmail());
        // 获取用户信息
        User user = getByUserName(emailLoginForm.getEmail());
        if (user == null){
            throw new BusinessException(ResponseCodeEnum.ERROR_MUST_REGISTER.getMsg());
        }
        // 判定用户状态
        Assert.isTrue(user.getStatus() == 1, ResponseCodeEnum.EMAIL_DISABLE_LOGIN.getMsg());

        // 校验密码
        boolean validate = AesEncryptUtils.validate(user.getPassword(), emailLoginForm.getPassword());
        Assert.isTrue(validate, ResponseCodeEnum.ERROR_PASSWORD.getMsg());

        // 获取用户详细信息
        UserAuth auth = baseMapper.selectById(user.getUserAuthId());

        // 登录
        StpUtil.login(user.getId());

        // 组装数据
        UserInfoVO userInfoVO = UserInfoVO.builder()
                .id(user.getId())
                .userInfoId(auth.getId())
                .avatar(auth.getAvatar())
                .nickname(auth.getNickname())
                .intro(auth.getIntro())
                .webSite(auth.getWebSite())
                .email(user.getUsername())
                .loginType(user.getLoginType())
                .token(StpUtil.getTokenValue())
                .build();

        return ResponseResult.success(userInfoVO);
    }

    /**
     * @param userId 用户id
     * @return com.blog.pojo.bo.UserAuthBO
     * @description 根据用户id获取用户信息
     */
    @Override
    public UserAuthBO getUserAuthByUserId(Long userId) {
        return BeanCopyUntils.copyBean(baseMapper.selectById(userId), UserAuthBO.class);
    }

    //================ 自定义方法 ===================

    /**
     * @author tur
     * @date 2023/4/1 15:26
     * @description 匹配邮箱格式是否正确
     * @param email 邮箱
     */
    private void checkEmail(String email){
        // 邮箱格式匹配
        boolean matches = Pattern.compile("\\w+@{1}\\w+\\.{1}\\w+").matcher(email).matches();
        // 对匹配结果进行判定，邮箱格式不对则抛出异常
        Assert.isTrue(matches, ResponseCodeEnum.EMAIL_ERROR.getMsg());
    }

    /**
     * @author tur
     * @date 2023/4/1 15:36
     * @description 依据用户名获取用户信息
     * @param username 用户名
     * @return com.blog.model.entity.User
     */
    private User getByUserName(String username){
        return userService.getOne(new QueryWrapper<User>().eq(SQLConstant.USERNAME, username));
    }
}
