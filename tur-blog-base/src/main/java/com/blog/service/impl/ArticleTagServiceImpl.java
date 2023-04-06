package com.blog.service.impl;

import com.blog.pojo.entity.ArticleTag;
import com.blog.mapper.ArticleTagMapper;
import com.blog.service.intf.ArticleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author tur
* @description 服务
* @version 1.0
* @date 2023-04-06
*/
@Slf4j
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    /**
     * @param tagId 标签id
     * @return com.blog.model.entity.ArticleTag
     * @description 根据标签id获取文章标签关联
     */
    @Override
    public List<ArticleTag> selectByTagId(Long tagId) {
        return baseMapper.selectByTagId(tagId);
    }

    /**
     * @param articleId 文章id
     * @return com.blog.model.entity.ArticleTag
     * @description 根据文章id查询标签id
     */
    @Override
    public List<ArticleTag> selectByArticleId(Long articleId) {
        return baseMapper.selectByArticleId(articleId);
    }
}
