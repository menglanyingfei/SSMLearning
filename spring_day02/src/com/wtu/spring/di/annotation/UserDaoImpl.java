package com.wtu.spring.di.annotation;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("IOC创建对象");
    }

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
