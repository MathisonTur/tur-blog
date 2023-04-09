package com.blog.service.impl;

import com.blog.pojo.entity.Menu;
import com.blog.mapper.MenuMapper;
import com.blog.service.intf.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author tur
* @description 系统管理-权限资源表 服务
* @version 1.0
* @date 2023-04-09
*/
@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
