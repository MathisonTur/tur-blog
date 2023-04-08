package com.blog.client;

import com.blog.pojo.bo.UserAuthBO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 22:15
 * @description 系统管理客户端
 */
@FeignClient("system-service")
@ApiOperation("用户信息客户端")
public interface SystemClient {

    /**
     * 根据用户id获取用户信息
     * */
    @GetMapping("/userAuth/{userId}")
    UserAuthBO getUserAuthByUserId(Long userId);
}
