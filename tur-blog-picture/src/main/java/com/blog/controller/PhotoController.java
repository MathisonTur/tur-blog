package com.blog.controller;

import com.blog.service.intf.PhotoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 照片接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="PhotoController", tags="照片业务接口")
public class PhotoController {

    @Resource
    private PhotoService  photoService;
}
