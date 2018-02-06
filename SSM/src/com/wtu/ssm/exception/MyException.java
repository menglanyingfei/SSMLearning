package com.wtu.ssm.exception;

/**
 * 自定义异常类
 * Author menglanyingfei
 * Created on 2018.01.25 16:37
 */
public class MyException extends Exception {
    // 保存错误信息
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
