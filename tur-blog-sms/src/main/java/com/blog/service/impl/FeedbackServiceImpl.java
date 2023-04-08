package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.FeedbackMapper;
import com.blog.pojo.entity.Feedback;
import com.blog.service.intf.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author tur
* @description 反馈表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

}
