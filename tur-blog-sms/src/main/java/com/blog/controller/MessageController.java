package com.blog.controller;

import com.blog.pojo.form.MessageForm;
import com.blog.service.intf.MessageService;
import com.blog.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 留言表接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="MessageController", tags="留言表业务接口")
public class MessageController {

    @Resource
    private MessageService  messageService;

    //=============================== web 方法 ==============================
    @GetMapping("/web/message/webMessage")
    @ApiOperation("留言列表")
    public ResponseResult webMessage(){
        return messageService.webMessage();
    }

    @PostMapping("/web/message/add")
    @ApiOperation("添加留言")
    public ResponseResult addMessage(@ApiParam("留言信息") @RequestBody MessageForm messageForm){
        return messageService.addMessage(messageForm);
    }
}
