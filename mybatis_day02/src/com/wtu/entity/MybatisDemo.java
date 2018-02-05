package com.wtu.entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.20 8:45
 */
public class MybatisDemo {

    // 根据id查找
    @Test
    public void findUserById() throws Exception {
        // 得到全局配置文件的输入流对象
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        // 得到Session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 得到SqlSession
        SqlSession session = factory.openSession();

        // 调用session的方法执行映射文件中的sql语句
        User user = session.selectOne("demo.findUserById", 28);
        System.out.println(user);

        // 关闭session
        session.close();
    }

    // 如果查询结果集中有多条记录, 那么使用selectList(String id, Object param)
    /*
        如果这时使用selectOne, 那么这时会抛出
        org.apache.ibatis.exceptions.TooManyResultsException:
        Expected one result (or null) to be returned by selectOne(), but found: 3
        异常
     */
    @Test
    public void findUserByName() throws Exception {
        // 得到全局配置文件的输入流对象
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        // 得到Session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 得到SqlSession
        SqlSession session = factory.openSession();

        // 调用session的方法执行映射文件中的sql语句
        List<User> userList = session.selectList("demo.findUserByName", "小");
        System.out.println(userList);

        // 关闭session
        session.close();
    }

    @Test
    public void insertUser() throws Exception {
        // 得到全局配置文件的输入流对象
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        // 得到Session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 得到SqlSession
        SqlSession session = factory.openSession();

        // 创建User对象
        User user = new User();
        user.setUsername("小阳");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("湖北武汉");
        // 调用的是session的insert()方法
        /*
            还传入的参数是一个User对象
            如果是增删改, 一定要记得提交事务

         */
        session.insert("demo.insertUser", user);
        System.out.println(user);
        session.commit();

        // 关闭session
        session.close();
    }

    @Test
    public void deleteUserById() throws Exception {
        // 得到全局配置文件的输入流对象
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        // 得到Session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 得到SqlSession
        SqlSession session = factory.openSession();

        session.delete("demo.deleteById", 24);
        session.commit();

        // 关闭session
        session.close();
    }

    @Test
    public void updateUser() throws Exception {
        // 得到全局配置文件的输入流对象
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        // 得到Session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 得到SqlSession
        SqlSession session = factory.openSession();

        // 创建对象
        User user = new User();
        user.setId(28);
        user.setUsername("小星");
        user.setSex("2");
        user.setBirthday(new Date());
        user.setAddress("武汉");

        session.update("demo.updateUser", user);
        session.commit();

        // 关闭session
        session.close();
    }
}










