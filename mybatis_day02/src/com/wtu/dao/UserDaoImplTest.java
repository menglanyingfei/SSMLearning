package com.wtu.dao;

import com.wtu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 测试类
 * @Author menglanyingfei
 * @Created on 2018.01.20 10:41
 */
public class UserDaoImplTest {

    private SqlSessionFactory factory;

    // 用来获取工厂
    @Before
    public void getFactory() throws Exception {
        this.factory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis/sqlMapConfig.xml"));
    }

    @Test
    public void testFindUser() throws Exception {
        // 获取UserDao对象
        UserDao userDao = new UserDaoImpl(factory);
        User user = userDao.findUserById(28);
        System.out.println(user);
    }

    @Test
    public void testFindAllUser() throws Exception {
        // 获取UserDao对象
        UserDao userDao = new UserDaoImpl(factory);
        List<User> userList = userDao.findAllUser();
        System.out.println(userList);
    }

    @Test
    public void testAddUser() throws Exception {
        // 获取UserDao对象
        UserDao userDao = new UserDaoImpl(factory);
        User user = new User();
        user.setUsername("小花");
        user.setSex("2");
        user.setBirthday(new Date());
        user.setAddress("武汉");
        userDao.addUser(user);

        System.out.println(user);
    }

    @Test
    public void deleteUser() throws Exception {
        // 获取UserDao对象
        UserDao userDao = new UserDaoImpl(factory);
        userDao.deleteUser(29);

    }

    @Test
    public void updateUser() throws Exception {
        // 获取UserDao对象
        UserDao userDao = new UserDaoImpl(factory);
        User user = new User();
        user.setId(28);
        user.setUsername("小阳");
        user.setSex("2");
        user.setBirthday(new Date());
        user.setAddress("武汉");
        userDao.updateUser(user);

        System.out.println(user);
    }
}
