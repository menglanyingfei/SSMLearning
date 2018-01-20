package com.wtu.spring.bean.life;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 14:27
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户!");
    }

    public void myInit() {
        System.out.println("获得和数据库的连接!");
    }

    public void myDestroy() {
        System.out.println("关闭连接释放资源!");
    }
}
