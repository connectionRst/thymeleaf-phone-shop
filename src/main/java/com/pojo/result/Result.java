package com.pojo.result;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
public class Result<T> implements Serializable {

    private boolean success;

    private int code;

    private String msg;

    private T data;

    public static<T> Result<T> success(){
        return success(null);
    }

    public static<T> Result<T> success(T data){
        return success(ResultCode.SUCCESS.getMessage(),data);
    }

    public static<T> Result<T> success(String message){
        return success(message,null);
    }

    public static<T> Result<T> success(String message,T data) {
        return success(ResultCode.SUCCESS.getCode(),message,data);
    }

    public static<T> Result<T> success(int code,String message){
        return success(code,message,null);
    }

    public static<T> Result<T> success(int code,String message,T data){
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMsg(message);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static<T> Result<T> failure(){
        return failure(ResultCode.SUCCESS.getMessage());
    }

    public static<T> Result<T> failure(String message){
        return failure(message,null);
    }

    public static<T> Result<T> failure(String message,T data){
        return failure(ResultCode.FAILURE.getCode(),message,data);
    }


    public static<T> Result<T> failure(int code ,String message) {
        return failure(ResultCode.FAILURE.getCode(),message,null);
    }


    public static<T> Result<T> failure(int code,String message,T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMsg(message);
        result.setSuccess(false);
        result.setData(data);
        return result;
    }

    public static<T> Result<T> decide(boolean b) {
        return decide(b,ResultCode.SUCCESS.getMessage(),ResultCode.FAILURE.getMessage());
    }

    public static<T> Result<T> decide(boolean b,String success,String failure) {
        if (b) {
            return success(success);
        } else {
            return failure(failure);
        }
    }
}
