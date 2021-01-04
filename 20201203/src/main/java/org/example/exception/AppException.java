package org.example.exception;

import lombok.Getter;

/**
 * program:20201203
 * description:
 * author:Zou zijuan
 * create:2020-12-03-00:42
 **/
@Getter
public class AppException extends RuntimeException {

    private String code;//报错抛异常时给定的错误码

    public AppException(String code, String message) {
//        super(message);
//        this.code = code;
        this(code, message, null);
    }

    public AppException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
