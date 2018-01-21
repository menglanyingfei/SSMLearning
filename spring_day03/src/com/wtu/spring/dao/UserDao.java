package com.wtu.spring.dao;

import java.util.List;

/**
 * Created by menglanyingfei on 2018/1/17.
 */
public interface UserDao {
    void addUser(Customer customer);
    void deleteUser(String id);

    Customer findCustomer(String id);
    List<Customer> findAllCustomer();
}
