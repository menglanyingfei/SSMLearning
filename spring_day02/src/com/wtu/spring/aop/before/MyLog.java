package com.wtu.spring.aop.before;

import java.util.Date;

/**
 * 切面
 * @Author menglanyingfei
 * @Created on 2018.01.17 17:06
 */
public class MyLog {
    @SuppressWarnings("deprecation")
    public void writeConsole() {
        System.out.println(new Date().toLocaleString());
    }
}
