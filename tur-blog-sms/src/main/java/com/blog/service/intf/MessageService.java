package com.blog.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.entity.Message;
import com.blog.pojo.form.MessageForm;
import com.blog.util.ResponseResult;

/**
 * @author tur
 * @description 留言表服务
 * @version 1.0
 * @date 2023-04-07
 */
public interface MessageService extends IService<Message> {

    /**
     * @description 留言列表
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult webMessage();

    /**
     * @description 添加留言
     * @param messageForm 留言信息
     * @return com.blog.utils.ResponseResult
     */
    ResponseResult addMessage(MessageForm messageForm);
}
