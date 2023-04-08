package com.blog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/3 22:35
 * @description 相册VO类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumVO {

    /**
     * id
     * */
    private Long id;

    /**
     * 相册名
     * */
    private String name;

    /**
     * 相册信息
     * */
    private String info;

    /**
     * 相册封面
     * */
    private String cover;
}
