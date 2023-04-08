package com.blog.constant;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/1 7:08
 * @description Redis常用常量
 */
public class RedisConstants {

    /**
     * 用户点赞的文章
     * */
    public static final String ARTICLE_USER_LIKE = "article_user_like";

    /**
     * 文章阅读量
     * */
    public static final String ARTICLE_READING = "article_reading";

    /**
     * 文章点赞量
     * */
    public static final String ARTICLE_LIKE_COUNT = "article_like_count";

    /**
     * 评论点赞量
     * */
    public static final String COMMENT_LIKE_COUNT = "comment_like_count";

    /**
     * 网站访问量
     * */
    public static final String BLOG_VIEWS_COUNT = "blog_views_count";

    /**
     * 网站访客
     */
    public static final String UNIQUE_VISITOR = "unique_visitor";

    /**
     * 访客地区
     * */
    public static final String VISITOR_AREA = "visitor_area";
}
