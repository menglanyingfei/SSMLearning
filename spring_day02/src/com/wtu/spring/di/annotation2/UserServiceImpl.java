package com.wtu.spring.di.annotation2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:05
 */

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
//    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("IOC容器创建UserServiceImpl对象");
    }

    /*
        spring会自动查找id为userDao的bean对象, 如果找到就通过下面的set方法注入进来
     */
//    @Resource(name = "userDao")
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void addUser() {
        System.out.println("service中addUser方法被调用了");
    }
}
