package com.blog.service.impl;

import com.blog.pojo.entity.Role;
import com.blog.mapper.RoleMapper;
import com.blog.service.intf.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author tur
* @description 系统管理-角色表 服务
* @version 1.0
* @date 2023-04-09
*/
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
