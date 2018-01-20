package com.wtu.spring.aop.before;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {

//        if (true) {
//            throw new RuntimeException("测试一下遇到异常执行情况");
//        }

        System.out.println("添加用户...");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
