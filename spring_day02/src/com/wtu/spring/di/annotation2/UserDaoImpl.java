package com.wtu.spring.di.annotation2;

import org.springframework.stereotype.Repository;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */

/**
 * @Component(value = "userDao")
 *  告诉SpringIOC容器创建一个id为userDao的bean对象
 *  value可以省略, 但是此时生成的id为类名, 并且首字母小写
 */
//@Component(value = "userDao") // userDaoImpl
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("IOC容器创建对象");
    }

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
