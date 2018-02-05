package com.wtu.mapper;

import com.wtu.entity.QueryVo;
import com.wtu.entity.User;
import com.wtu.entity.UserCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.20 14:32
 */
public class MapperTest {
    private SqlSessionFactory factory;

    @Before
    public void getFactory() throws Exception {
        this.factory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis/sqlMapConfig.xml"));
    }

    @Test
    public void testFindUserByName() {
        // 获取SqlSession
        SqlSession session = factory.openSession();
        // 通过SqlSession对象得到Mapper接口的一个代理对象
        // 需要传递的参数是Mapper接口的类型
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 通过代理对象调用UserMapper中的方法
        List<User> userList = userMapper.findUserByName("小");
        System.out.println(userList);
        // 红色标识!
        System.err.println(userMapper);

        // 关闭资源
        session.close();
    }

    @Test
    public void insertUser() {
        // 获取SqlSession
        SqlSession session = factory.openSession();
        // 通过SqlSession对象得到Mapper接口的一个代理对象
        // 需要传递的参数是Mapper接口的类型
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("小樱");
        user.setSex("2");
        user.setBirthday(new Date());
        user.setAddress("武汉");

        // 通过代理对象调用UserMapper中的方法
        userMapper.insertUser(user);
        session.commit();

        System.out.println(user);
        // 红色标识!
        System.err.println(userMapper);

        // 关闭资源
        session.close();
    }

    @Test
    public void findUserBySexAndUsername() {
        // 获取SqlSession
        SqlSession session = factory.openSession();
        // 通过SqlSession对象得到Mapper接口的一个代理对象
        // 需要传递的参数是Mapper接口的类型
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 构建输入参数QueryVo
        QueryVo queryVo = new QueryVo();
        // 创建UserCustomer对象作为queryVo的属性
        UserCustomer userCustomer = new UserCustomer();

        userCustomer.setUsername("小");
        userCustomer.setSex("1");

        // 将UserCustomer对象设置到QueryVo中
        queryVo.setUserCustomer(userCustomer);

        // 通过代理对象调用UserMapper中的方法
        List<UserCustomer> userList = userMapper.findUserByNameAndSex(queryVo);

        System.out.println(userList);

        // 红色标识!
        System.err.println(userMapper);

        // 关闭资源
        session.close();
    }

    @Test
    public void findUserByHashMap() {
        // 获取SqlSession
        SqlSession session = factory.openSession();
        // 通过SqlSession对象得到Mapper接口的一个代理对象
        // 需要传递的参数是Mapper接口的类型
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 创建HashMap对象
        HashMap<String, Object> map = new HashMap<>();
        map.put("sex", "1");
        map.put("username1", "小");

        // 通过代理对象调用UserMapper中的方法
        List<UserCustomer> userList = userMapper.findUserByHashMap(map);

        System.err.println(userList);
        System.out.println(map.get("username1"));

        // 关闭资源
        session.close();
    }
}




















