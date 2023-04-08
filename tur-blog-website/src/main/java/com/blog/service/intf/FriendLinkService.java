package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.entity.FriendLink;
import com.blog.pojo.form.FriendLinkForm;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 友情链接表服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface FriendLinkService extends IService<FriendLink> {

    /**
     * @description 友链列表
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult friendLinkList();

    /**
     * @description 申请友链
     * @param friendLinkForm 友链信息
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult addFriendLink(FriendLinkForm friendLinkForm);
}
