package com.wtu.mapper;

import com.wtu.pojo.Orders;
import com.wtu.pojo.User;

import java.util.List;

/**
 * Created by menglanyingfei on 2018/1/21.
 */
public interface OrdersMapper {
    // 查询订单并且关联查询用户信息, 延迟加载用户信息
    List<Orders> findOrdersLazyLoadingUser();

    User findUserById(Integer id);

    void updateUser(User user1);
}
