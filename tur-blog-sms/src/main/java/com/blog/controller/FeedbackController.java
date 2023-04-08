package com.blog.controller;

import com.blog.service.intf.FeedbackService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tur
 * @description 反馈表接口
 * @version 1.0
 * @date 2023-04-07
 */
@Slf4j
@RestController
@Api(value="FeedbackController", tags="反馈表业务接口")
public class FeedbackController {

    @Resource
    private FeedbackService  feedbackService;
}
