package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.entity.PhotoAlbum;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 相册服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface PhotoAlbumService extends IService<PhotoAlbum> {

    /**
     * @description 相册列表
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult photoAlbumList();

    /**
     * @description 根据相册id获取照片列表
     * @param albumId 相册id
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult listPhotos(Long albumId, Long pageNo, Long pageSize);
}
