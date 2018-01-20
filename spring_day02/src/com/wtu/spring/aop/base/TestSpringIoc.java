package com.wtu.spring.aop.base;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:22
 */
public class TestSpringIoc {
    public static void main(String[] args) {
        // 通过一个中间类来获取代理对象
        Middle middle = new Middle();
        UserDao userDao = (UserDao) middle.getObject();
        userDao.addUser();


        System.out.println(userDao);
        //com.wtu.spring.aop.base.UserDaoImpl@5305068a
        System.out.println(userDao.getClass());
        // 使用JDK动态代理产生的代理对象
        //class com.sun.proxy.$Proxy0

    }
}



