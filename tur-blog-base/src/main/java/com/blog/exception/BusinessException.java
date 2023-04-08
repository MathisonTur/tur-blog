package com.blog.exception;

import com.blog.enums.ResponseCodeEnum;
import lombok.Data;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/1 15:39
 * @description 异常返回类
 */
@Data
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 6401507641198338287L;

    /** 异常代码 */
    protected Integer code;

    /** 异常消息 */
    protected String message;

    public BusinessException() {
        super();
    }

    public BusinessException(ResponseCodeEnum responseCodeEnum) {
        super(responseCodeEnum.getMsg());
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMsg();
    }

    public BusinessException(String msg) {
        super(msg);
        this.code = ResponseCodeEnum.ERROR.getCode();
        this.message = msg;
    }

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.message = msg;
    }

    public BusinessException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.message = msg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.code = ResponseCodeEnum.ERROR.getCode();
        this.message = cause.getMessage();
    }
}
