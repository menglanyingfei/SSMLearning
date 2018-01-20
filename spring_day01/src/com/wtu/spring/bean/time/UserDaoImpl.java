package com.wtu.spring.bean.time;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 14:27
 */
public class UserDaoImpl implements IUserDao {
    public UserDaoImpl() {
        System.out.println("spring ioc创建对象");
    }

    @Override
    public void addUser() {
        System.out.println("添加用户!");
    }
}
