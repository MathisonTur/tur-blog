package com.blog.service.intf;

import com.blog.pojo.bo.TagBO;
import com.blog.pojo.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author tur
 * @description 博客标签表服务
 * @version 1.0
 * @date 2023-04-06
 */
public interface TagService extends IService<Tag> {

    /**
     * @description 根据文章id获取标签列表
     * @param articleId 文章id
     * @return java.util.List<com.blog.pojo.bo.TagBO>
    */
    List<TagBO> getTagByArticleId(Long articleId);
}
