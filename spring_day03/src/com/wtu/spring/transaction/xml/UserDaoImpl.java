package com.wtu.spring.transaction.xml;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("增加用户...");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户...");
    }
}
