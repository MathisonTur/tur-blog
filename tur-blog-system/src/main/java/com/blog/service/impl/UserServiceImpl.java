package com.blog.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.UserMapper;
import com.blog.pojo.entity.User;
import com.blog.pojo.entity.UserAuth;
import com.blog.pojo.vo.UserVO;
import com.blog.service.intf.UserAuthService;
import com.blog.service.intf.UserService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
* @author tur
* @description 系统管理-用户基础信息表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Lazy
    @Resource
    UserAuthService userAuthService;

    //------------------ 后台接口 ------------------
    /**
     * @return com.blog.utils.ResponseResult 无data
     * @description 获取当前登录用户的信息
     */
    @Override
    public ResponseResult getCurrentUserInfo() {
        User user = baseMapper.selectById((Serializable) StpUtil.getLoginId());
        UserAuth userAuth = userAuthService.getById(user.getUserAuthId());
        UserVO userVO = BeanCopyUntils.copyBean(user, UserVO.class);
        userVO.setNickname(userAuth.getNickname());
        userVO.setAvatar(userAuth.getAvatar());
        return ResponseResult.success(userVO);
    }

    /**
     * @return com.blog.util.ResponseResult
     * @description 获取用户菜单信息
     */
    @Override
    public ResponseResult getUserMenu() {
        return null;
    }
}
