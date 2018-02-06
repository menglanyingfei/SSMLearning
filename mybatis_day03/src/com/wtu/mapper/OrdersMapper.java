package com.wtu.mapper;

import com.wtu.pojo.Orders;
import com.wtu.pojo.OrdersCustomer;
import com.wtu.pojo.User;

import java.util.List;

/**
 * Created by menglanyingfei on 2018/1/21.
 */
public interface OrdersMapper {
    // 查询订单信息, 并且查询该订单对应的用户部分信息
    List<OrdersCustomer> findOrdersAndUser();

    // 查询订单信息, 并且查询该订单对应的用户部分信息, 采用ResultMap作为输出参数
    List<Orders> findOrdersAndUserByResultMap();

    // 查询订单信息并且关联用户信息和对应的订单明细的信息
    List<Orders> findOrdersAndUserAndOrderdetail();

    // 查询用户信息并且关联查询用户购买的商品的信息
    List<User> findUserToItems();
}
