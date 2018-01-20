package com.wtu.spring.di.annotation;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:05
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("IOC创建UserServiceImpl对象");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        System.out.println("service中 addUser方法");
    }
}
