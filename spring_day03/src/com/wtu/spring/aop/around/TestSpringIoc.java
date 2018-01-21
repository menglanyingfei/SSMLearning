package com.wtu.spring.aop.around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:22
 */
public class TestSpringIoc {
    public static void main(String[] args) {
        // 启动Ioc容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/aop/around/spring3.0.xml"}
        );

        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.addUser();

        System.out.println(userDao.getClass());
        //class com.wtu.spring.aop.before.UserDaoImpl$$EnhancerByCGLIB$$aa48c241
    }
}



