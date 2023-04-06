package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.TagMapper;
import com.blog.pojo.bo.TagBO;
import com.blog.pojo.entity.Tag;
import com.blog.service.intf.ArticleTagService;
import com.blog.service.intf.TagService;
import com.blog.util.BeanCopyUntils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author tur
* @description 博客标签表服务
* @version 1.0
* @date 2023-04-06
*/
@Slf4j
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Resource
    ArticleTagService articleTagService;

    /**
     * @param articleId 文章id
     * @return java.util.List<com.blog.pojo.bo.TagBO>
     * @description 根据文章id获取标签列表
     */
    @Override
    public List<TagBO> getTagByArticleId(Long articleId) {
        List<Tag> tagList = new ArrayList<>();
        articleTagService.selectByArticleId(articleId).forEach(articleTag -> tagList.add(baseMapper.selectById(articleTag.getTagId())));
        return BeanCopyUntils.copyBeanList(tagList, TagBO.class);
    }
}
