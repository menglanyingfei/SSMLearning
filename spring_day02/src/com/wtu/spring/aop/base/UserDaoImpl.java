package com.wtu.spring.aop.base;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("添加用户...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
