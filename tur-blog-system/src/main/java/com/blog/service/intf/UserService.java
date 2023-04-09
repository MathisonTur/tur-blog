package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.entity.User;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 系统管理-用户基础信息表服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface UserService extends IService<User> {

    //=============== 后台接口 =================
    /**
     * @description 获取当前登录用户的信息
     * @return com.blog.utils.ResponseResult 无data
     */
    ResponseResult getCurrentUserInfo();

    /**
     * @description 获取用户菜单信息
     * @return com.blog.util.ResponseResult
    */
    ResponseResult getUserMenu();
}
