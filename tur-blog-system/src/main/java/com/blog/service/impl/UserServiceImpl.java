package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.UserMapper;
import com.blog.pojo.entity.User;
import com.blog.service.intf.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author tur
* @description 系统管理-用户基础信息表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
