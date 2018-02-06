package com.wtu.ssm.dao;

import com.wtu.ssm.entity.User;

/**
 * Created by menglanyingfei on 2018/1/22.
 */
public interface UserDao {
    User findUserById(Integer id);
}
