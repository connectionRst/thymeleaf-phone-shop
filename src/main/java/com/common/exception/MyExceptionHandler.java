package com.common.exception;

import com.pojo.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    //全局异常捕获
    public Result exceptionHandler(Exception e){
        e.printStackTrace();
        return Result.failure("系统出错了。。。",e.getMessage());
    }
}
