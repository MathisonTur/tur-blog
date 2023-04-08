package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.SQLConstant;
import com.blog.enums.YesOrNoEnum;
import com.blog.mapper.PhotoAlbumMapper;
import com.blog.pojo.entity.Photo;
import com.blog.pojo.entity.PhotoAlbum;
import com.blog.pojo.vo.AlbumVO;
import com.blog.pojo.vo.PhotoListVO;
import com.blog.service.intf.PhotoAlbumService;
import com.blog.service.intf.PhotoService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author tur
* @description 相册服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class PhotoAlbumServiceImpl extends ServiceImpl<PhotoAlbumMapper, PhotoAlbum> implements PhotoAlbumService {

    @Resource
    private PhotoService photoService;

    /**
     * @return com.blog.utils.ResponseResult
     * @author tur
     * @date 2023/4/3 22:29
     * @description 相册列表
     */
    @Override
    public ResponseResult photoAlbumList() {
        // 构建查询条件
        QueryWrapper<PhotoAlbum> queryWrapper = new QueryWrapper<>();
        // 获取公开的相册
        queryWrapper.eq(SQLConstant.STATUS, YesOrNoEnum.NO.getCode());

        List<AlbumVO> albumVOList = BeanCopyUntils.copyBeanList(baseMapper.selectList(queryWrapper), AlbumVO.class);

        return ResponseResult.success(albumVOList);
    }

    /**
     * @param albumId  相册id
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return com.blog.utils.ResponseResult
     * @author tur
     * @date 2023/4/3 22:32
     * @description 根据相册id获取照片列表
     */
    @Override
    public ResponseResult listPhotos(Long albumId, Long pageNo, Long pageSize) {
        LambdaQueryWrapper<Photo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Photo::getUrl).eq(Photo::getAlbumId, albumId);
        Page<Photo> photoPage = photoService.getBaseMapper().selectPage(new Page<>(pageNo, pageSize),queryWrapper);

        List<String> urlList = new ArrayList<>();
        photoPage.getRecords().forEach(item -> urlList.add(item.getUrl()));
        PhotoAlbum photoAlbum = baseMapper.selectById(albumId);

        PhotoListVO photoListVO = PhotoListVO.builder()
                .photoList(urlList)
                .photoAlbumCover(photoAlbum.getCover())
                .photoAlbumName(photoAlbum.getName())
                .build();

        return ResponseResult.success(photoListVO);
    }
}
