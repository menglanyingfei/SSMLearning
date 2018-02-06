package com.wtu.test;

import com.wtu.mapper.OrdersMapper;
import com.wtu.pojo.Orders;
import com.wtu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.22 8:54
 */
public class OrdersMapperTest {
    private SqlSessionFactory factory;

    @Before
    public void getFactory() throws IOException {
        this.factory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis/sqlMapConfig.xml")
        );
    }

    @Test
    // 查询订单并且关联查询用户信息, 延迟加载用户信息
    public void findOrdersLazyLoadingUser() {
        SqlSession session = factory.openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);

        List<Orders> ordersList = ordersMapper.findOrdersLazyLoadingUser();
        System.out.println(ordersList);

        // 在此处获取用户的信息
        for (Orders orders : ordersList) {
            User user = orders.getUser();
            System.out.println(user);
        }
    }

    @Test
    // 测试一级缓存
    public void findUserById() {
        SqlSession session = factory.openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);

        User user1 = ordersMapper.findUserById(28);
        System.out.println(user1);
        user1.setUsername("study");
        // 修改用户信息, 会清除掉SqlSession中的缓存, 第二次查询的时候, 会再次从数据库中查询
        ordersMapper.updateUser(user1);
        session.commit();

        User user2 = ordersMapper.findUserById(28);
        System.out.println(user2);
    }

    // 测试二级缓存
    @Test
    public void testCache2() {
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        SqlSession session3 = factory.openSession();

        OrdersMapper mapper1 = session1.getMapper(OrdersMapper.class);
        OrdersMapper mapper2 = session2.getMapper(OrdersMapper.class);
        OrdersMapper mapper3 = session3.getMapper(OrdersMapper.class);

        User user1 = mapper1.findUserById(28);
        System.out.println(user1);
        session1.close();

        // 修改用户信息, 会清除掉二级缓存, 第二次查询的时候, 会再次从数据库中查询
        user1.setUsername("learn");
        mapper3.updateUser(user1);
        session3.commit();
        session3.close();

        User user2 = mapper2.findUserById(28);
        System.out.println(user2);
        session2.close();
    }
}













