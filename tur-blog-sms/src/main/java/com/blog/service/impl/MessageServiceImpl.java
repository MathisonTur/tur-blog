package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.MessageMapper;
import com.blog.pojo.entity.Message;
import com.blog.pojo.form.MessageForm;
import com.blog.pojo.vo.MessageVO;
import com.blog.service.intf.MessageService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.IpUtils;
import com.blog.util.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author tur
* @description 留言表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    private final HttpServletRequest request;

    /**
     * @return com.blog.utils.ResponseResult
     * @description 留言列表
     */
    @Override
    public ResponseResult webMessage() {
        List<MessageVO> messageVOList = BeanCopyUntils.copyBeanList(list(), MessageVO.class);
        return ResponseResult.success(messageVOList);
    }

    /**
     * @param messageForm 留言信息
     * @return com.blog.utils.ResponseResult
     * @description 添加留言
     */
    @Override
    public ResponseResult addMessage(MessageForm messageForm) {
        Message message = BeanCopyUntils.copyBean(messageForm, Message.class);
        String ipAddress = IpUtils.getIp(request);
        String ipSource = IpUtils.getCityInfo(ipAddress);
        message.setIpAddress(ipAddress);
        message.setIpSource(ipSource);
        baseMapper.insert(message);

        return ResponseResult.success("留言成功");
    }
}
