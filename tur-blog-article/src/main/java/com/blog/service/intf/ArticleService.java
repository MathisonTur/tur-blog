package com.blog.service.intf;

import com.blog.pojo.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 博客文章表服务
 * @version 1.0
 * @date 2023-04-06
 */
public interface ArticleService extends IService<Article> {

    /**
     * @description 分页获取文章列表
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return com.blog.util.ResponseResult
    */
    ResponseResult getArticlePage(Long pageNo, Long pageSize);
}
