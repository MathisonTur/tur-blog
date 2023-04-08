package com.blog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 20:56
 * @description 照片列表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoListVO {
    /**
     * 照片列表
     * */
    private List<String> photoList;

    /**
     * 相册名
     * */
    private String photoAlbumName;

    /**
     * 相册封面
     * */
    private String photoAlbumCover;
}
