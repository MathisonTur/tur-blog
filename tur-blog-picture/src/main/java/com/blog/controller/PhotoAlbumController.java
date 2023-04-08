package com.blog.controller;

import com.blog.service.intf.PhotoAlbumService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 相册接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="PhotoAlbumController", tags="相册业务接口")
public class PhotoAlbumController {

    @Resource
    private PhotoAlbumService  photoAlbumService;

    //-------------------- web 方法 ------------------------
    @GetMapping("/web/album/list")
    @ApiOperation("相册列表")
    public ResponseResult photoAlbumList(){
        return photoAlbumService.photoAlbumList();
    }

    @GetMapping("/web/album/listPhotos")
    @ApiOperation("照片列表")
    public ResponseResult listPhotos(
            @ApiParam("相册id") @RequestParam Long albumId,
            @ApiParam("页码") @RequestParam Long pageNo,
            @ApiParam("每页数量") @RequestParam Long pageSize){
        return photoAlbumService.listPhotos(albumId, pageNo, pageSize);
    }
}
