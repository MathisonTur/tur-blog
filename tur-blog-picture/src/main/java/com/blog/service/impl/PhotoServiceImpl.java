package com.blog.service.impl;

import com.blog.pojo.entity.Photo;
import com.blog.mapper.PhotoMapper;
import com.blog.service.intf.PhotoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author tur
* @description 照片服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {

}
