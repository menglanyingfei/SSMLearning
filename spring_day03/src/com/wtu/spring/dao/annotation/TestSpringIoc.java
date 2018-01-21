package com.wtu.spring.dao.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:22
 */
public class TestSpringIoc {
    public static void main(String[] args) {
        // 启动IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/dao/annotation/spring3.0.xml"});

        UserDao userDao = (UserDao) ac.getBean("userDaoImpl");
        Customer c = userDao.findCustomer("no4");
        System.out.println(c);
    }
}



