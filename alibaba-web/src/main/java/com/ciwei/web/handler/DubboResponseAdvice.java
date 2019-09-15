package com.ciwei.web.handler;

import com.ciwei.common.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @NAME DubboResponseAdvice
 * @USER Ciwei
 * @DATE 2019/9/15/015 11:01
 **/
@RestControllerAdvice
public class DubboResponseAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseMessage handlerAdException(HttpServletRequest request ,Exception exception){
        return ResponseMessage.fail("500" ,exception.getMessage());
    }

}
