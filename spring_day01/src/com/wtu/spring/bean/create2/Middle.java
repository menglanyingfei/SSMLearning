package com.wtu.spring.bean.create2;

/**
 * 中间类 创建对象
 * @Author menglanyingfei
 * @Created on 2018.01.16 14:37
 */
public class Middle {
    public Middle() {
        System.out.println("spring IOC 容器创建中间类对象");
    }

    public static IUserDao getInstance() {
        return new UserDaoImpl("带参");
    }
}
