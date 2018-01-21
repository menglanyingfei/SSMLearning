package com.wtu.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.18 16:29
 */
public class MybatisDemo {

    @Test
    public void findUserById() throws Exception {
        // 得到MyBatis全局配置文件的输入流对象
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        // 得到SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 得到SqlSession对象
        SqlSession session = factory.openSession();
        // 根据id查询用户
        /*
            param1: 映射文件中的sql id 格式是命名空间.sqlID
            param2: 查询语句需要带的参数
         */
        User user = session.selectOne("demo.findUserById", 10);
        System.out.println(user);
    }
}




















