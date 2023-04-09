package com.blog.service.impl;

import com.blog.pojo.entity.RoleMenu;
import com.blog.mapper.RoleMenuMapper;
import com.blog.service.intf.RoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author tur
* @description 系统管理 - 角色-权限资源关联表 服务
* @version 1.0
* @date 2023-04-09
*/
@Slf4j
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
