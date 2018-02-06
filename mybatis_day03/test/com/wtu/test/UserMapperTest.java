package com.wtu.test;

import com.wtu.mapper.UserMapper;
import com.wtu.pojo.QueryVo;
import com.wtu.pojo.User;
import com.wtu.pojo.UserCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.21 8:50
 */
public class UserMapperTest {
    private SqlSessionFactory factory;

    @Before
    public void getFactory() throws Exception {
        this.factory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis/sqlMapConfig.xml")
        );
    }

    @Test
    public void findUserCount() {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setSex("1");
        userCustomer.setUsername("小");
        queryVo.setUserCustomer(userCustomer);
        Integer count = userMapper.findUserCount(queryVo);

        System.out.println(count);
//        System.err.println(userMapper);
        session.close();
    }

    @Test
    public void findUserById() {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        HashMap<String, Object> map = userMapper.findUserById(28);

        System.out.println(map);
        session.close();
    }

    @Test
    public void findUserById2() {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findUserById2(28);

        System.out.println(user);
        session.close();
    }

    @Test
    public void findUserByResultMap() {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findUserByResultMap(28);

        System.out.println(user);
        session.close();
    }

    @Test
    public void findUserByUserNameAndSex() {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 创建查询条件
        QueryVo queryVo = new QueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setSex("1");
        userCustomer.setUsername("小");
        queryVo.setUserCustomer(userCustomer);

        List<UserCustomer> userList = userMapper.findUserByUserNameAndSex(queryVo);

        System.out.println(userList);
        session.close();
    }

    // 查询用户名中带小字, 性别为1, 用户id为28, 30的用户
    @Test
    public void findUserByUserNameAndSex2() {
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 创建查询条件
        QueryVo queryVo = new QueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setSex("2");
        userCustomer.setUsername("小");
        // 给QueryVo封装ids属性
        List<Integer> ids = new ArrayList<>();
        ids.add(28);
        ids.add(30);
        queryVo.setIds(ids);
        queryVo.setUserCustomer(userCustomer);

        List<UserCustomer> userList = userMapper.findUserByUserNameAndSex2(queryVo);

        System.out.println(userList);
        session.close();
    }


}




































