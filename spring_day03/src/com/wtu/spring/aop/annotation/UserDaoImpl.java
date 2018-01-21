package com.wtu.spring.aop.annotation;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    @Pointcut
    public void addUser() {
        System.out.println("查询用户...");
    }

    @Override
    @Pointcut
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
