package com.wtu.dao;

import com.wtu.entity.User;

import java.util.List;

/**
 * Created by menglanyingfei on 2018/1/20.
 */
public interface UserDao {
    void addUser(User user) throws Exception;
    void deleteUser(Integer id) throws Exception;
    void updateUser(User user) throws Exception;
    User findUserById(Integer id) throws Exception;
    List<User> findAllUser() throws Exception;
}
