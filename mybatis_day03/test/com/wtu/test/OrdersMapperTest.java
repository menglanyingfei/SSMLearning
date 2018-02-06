package com.wtu.test;

import com.wtu.mapper.OrdersMapper;
import com.wtu.pojo.Orders;
import com.wtu.pojo.OrdersCustomer;
import com.wtu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.21 11:32
 */
public class OrdersMapperTest {
    private SqlSessionFactory factory;

    @Before
    public void getFactory() throws Exception {
        this.factory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis/sqlMapConfig.xml")
        );
    }

    // 查询订单信息, 并且查询该订单对应的用户部分信息
    @Test
    public void findOrdersAndUser() {
        SqlSession session = factory.openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);

        List<OrdersCustomer> ordersCustomerList = ordersMapper.findOrdersAndUser();

        for (OrdersCustomer oc : ordersCustomerList) {
            System.out.println(oc.getUsername() + " -- " + oc.getSex() + " -- "
                + oc.getAddress());
        }

        session.close();
    }

    // 查询订单信息, 并且查询该订单对应的用户部分信息, 采用ResultMap作为输出参数
    @Test
    public void findOrdersAndUserByResultMap() {
        SqlSession session = factory.openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);

        List<Orders> ordersList = ordersMapper.findOrdersAndUserByResultMap();

        System.out.println(ordersList);
        session.close();
    }

    // 查询订单信息, 并且查询该订单对应的用户部分信息, 采用ResultMap作为输出参数
    @Test
    public void findOrdersAndUserAndOrderdetail() {
        SqlSession session = factory.openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);

        List<Orders> ordersList = ordersMapper.findOrdersAndUserAndOrderdetail();

        System.out.println(ordersList);
        session.close();
    }

    // 查询用户信息并且关联查询用户购买的商品的信息
    @Test
    public void findUserToItems() {
        SqlSession session = factory.openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);

        List<User> userList = ordersMapper.findUserToItems();

        System.out.println(userList);
        session.close();
    }
}
