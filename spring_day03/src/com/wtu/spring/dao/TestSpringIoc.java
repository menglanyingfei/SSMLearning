package com.wtu.spring.dao;

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
        // 启动Ioc容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/dao/spring3.0.xml"}
        );

        UserDao userDao = (UserDao) ac.getBean("userDao");
//        Customer c = new Customer();
//        c.setId("no3");
//		c.setName("Java");
//		c.setGender("女");
//		c.setBirthday(new Date());
//		c.setCellphone("0011223366");
//		c.setEmail("sdfsdf@sina.com");
//		c.setDescription("这是个美女！！！");

//		userDao.addUser(c);

//        Customer c = userDao.findCustomer("no2");
//        System.out.println(c);

        List<Customer> list = userDao.findAllCustomer();

        for (Customer c : list) {
            System.out.println(c.toString());
        }

    }
}



