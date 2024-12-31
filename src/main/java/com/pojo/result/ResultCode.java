package com.pojo.result;

import lombok.Getter;

public enum ResultCode {

    SUCCESS(200,"操作成功"),

    FAILURE(500,"操作失败");

    @Getter
    private final int code;

    @Getter
    private final String message;

    ResultCode(int code, String message) {

        this.code = code;

        this.message = message;
    }

}
