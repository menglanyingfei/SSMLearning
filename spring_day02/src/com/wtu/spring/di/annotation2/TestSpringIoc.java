package com.wtu.spring.di.annotation2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:22
 */
public class TestSpringIoc {
    public static void main(String[] args) {
        // 启动IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/di/annotation2/spring3.0.xml"}
        );

        UserService us = (UserService) ac.getBean("userServiceImpl");
        us.addUser();
    }
}
