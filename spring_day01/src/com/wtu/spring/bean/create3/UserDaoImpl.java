package com.wtu.spring.bean.create3;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 14:27
 */
public class UserDaoImpl implements IUserDao {
    public UserDaoImpl(String str) {
        System.out.println("通过带参的构造方法创建对象");
    }

    @Override
    public void addUser() {
        System.out.println("添加用户!");
    }
}
