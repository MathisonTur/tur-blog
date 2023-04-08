package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.bo.TagBO;
import com.blog.pojo.entity.Tag;
import com.blog.util.ResponseResult;

import java.util.List;

/**
 * @author tur
 * @description 博客标签表服务
 * @version 1.0
 * @date 2023-04-06
 */
public interface TagService extends IService<Tag> {

    //========================= web方法 ============================
    /**
     * @description 分类列表
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult getTagList();

    //======================== 其他服务方法 ===========================
    /**
     * @description 根据文章id获取标签列表
     * @param articleId 文章id
     * @return java.util.List<com.blog.service.intf.pojo.bo.TagBO>
    */
    List<TagBO> getTagByArticleId(Long articleId);

    /**
     * @description 根据id获取标签
     * @param id 标签id
     * @return com.blog.service.intf.pojo.bo.TagBO
    */
    TagBO getTagById(Long id);

    /**
     * @description 查询标签数量
     * @return java.lang.Long
     */
    Long selectCount();
}
