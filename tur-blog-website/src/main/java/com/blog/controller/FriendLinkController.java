package com.blog.controller;

import com.blog.pojo.form.FriendLinkForm;
import com.blog.service.intf.FriendLinkService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 友情链接表接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="FriendLinkController", tags="友情链接表业务接口")
public class FriendLinkController {

    @Resource
    private FriendLinkService  friendLinkService;

    @PostMapping("/web/friend/list")
    @ApiOperation("友链列表")
    public ResponseResult friendLinkList(){
        return friendLinkService.friendLinkList();
    }

    @PostMapping("/web/friend/add")
    @ApiOperation("申请友链")
    public ResponseResult addFriendLink(@ApiParam("友链信息") @RequestBody FriendLinkForm friendLinkForm){
        return friendLinkService.addFriendLink(friendLinkForm);
    }
}
