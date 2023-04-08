package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.TagMapper;
import com.blog.pojo.bo.TagBO;
import com.blog.pojo.entity.Tag;
import com.blog.pojo.vo.TagVO;
import com.blog.service.intf.ArticleTagService;
import com.blog.service.intf.TagService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
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

    //============================ web方法 ==========================
    /**
     * @return com.blog.utils.ResponseResult
     * @description 分类列表
     */
    @Override
    public ResponseResult getTagList() {
        List<TagVO> tagVOList = BeanCopyUntils.copyBeanList(list(), TagVO.class);
        return ResponseResult.success(tagVOList);
    }

    //==================== 其他服务方法 ===============================
    /**
     * @param articleId 文章id
     * @return java.util.List<com.blog.service.intf.pojo.bo.TagBO>
     * @description 根据文章id获取标签列表
     */
    @Override
    public List<TagBO> getTagByArticleId(Long articleId) {
        List<Tag> tagList = new ArrayList<>();
        articleTagService.selectByArticleId(articleId).forEach(articleTag -> tagList.add(baseMapper.selectById(articleTag.getTagId())));
        return BeanCopyUntils.copyBeanList(tagList, TagBO.class);
    }

    /**
     * @param id 标签id
     * @return com.blog.service.intf.pojo.bo.TagBO
     * @description 根据id获取标签
     */
    @Override
    public TagBO getTagById(Long id) {
        return BeanCopyUntils.copyBean(baseMapper.selectById(id), TagBO.class);
    }

    /**
     * @return java.lang.Long
     * @description 查询标签数量
     */
    @Override
    public Long selectCount() {
        return baseMapper.selectCount(null);
    }
}
