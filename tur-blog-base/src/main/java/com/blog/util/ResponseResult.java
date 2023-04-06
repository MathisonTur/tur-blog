package com.blog.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import static com.blog.enums.ResponseCodeEnum.FAILURE;
import static com.blog.enums.ResponseCodeEnum.SUCCESS;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/26 18:24
 * @description 统一返回结果类
 */
@Data
@ApiModel(value = "ResponseResult", description = "统一返回结果类")
public class ResponseResult {

    @ApiModelProperty(value = "响应码", required = true)
    private Integer code;

    @ApiModelProperty(value = "响应数据", required = false)
    private Object data;

    @ApiModelProperty(value = "响应消息", required = false)
    private String message;

    public ResponseResult(Integer code, String message, Object data) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * @author tur
     * @date 2023/3/26 22:33
     * @description 响应成功返回
     * @return com.blog.utils.ResponseResult
    */
    public static ResponseResult success(){
        return new ResponseResult(SUCCESS.getCode(), SUCCESS.getMsg(), null);
    }
    public static ResponseResult success(Object data){
        return new ResponseResult(SUCCESS.getCode(), SUCCESS.getMsg(), data);
    }
    public static ResponseResult success(Integer code, String message){
        return new ResponseResult(code, message, null);
    }
    public static ResponseResult success(String message, Object data){
        return new ResponseResult(SUCCESS.getCode(), message, data);
    }
    public static ResponseResult success(Integer code, String message, Object data){
        return new ResponseResult(code, message, data);
    }

    /**
     * @author tur
     * @date 2023/3/26 22:03
     * @description 响应失败时返回的结果
     * @return com.blog.utils.ResponseResult
     */
    public static ResponseResult error(){
        return new ResponseResult(FAILURE.getCode(), FAILURE.getMsg(), null);
    }
    public static ResponseResult error(String message){
        return new ResponseResult(FAILURE.getCode(), message, null);
    }
    public static ResponseResult error(Integer code, String message){
        return new ResponseResult(code, message,  null);
    }
}
