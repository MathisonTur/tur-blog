package com.blog.client;

import com.blog.pojo.bo.TagBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/6 19:17
 * @description 标签客户端
 */
@FeignClient(name = "tag-service", path = "/tag")
public interface TagClient {

    /**
     * @description 根据文章id获取标签列表
     * @param articleId 文章id
     * @return java.util.List<com.blog.pojo.bo.TagBO>
    */
    @GetMapping("/list/{articleId}")
    List<TagBO> getTagByArticleId(@PathVariable("articleId") Long articleId);

    /**
     * @description 根据id获取标签信息
     * @param id 标签id
     * @return com.blog.pojo.bo.TagBO
    */
    @GetMapping("/{id}")
    TagBO getTagById(@PathVariable("id") Long id);
}
