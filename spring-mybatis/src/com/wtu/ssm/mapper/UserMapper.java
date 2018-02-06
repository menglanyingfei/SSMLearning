package com.wtu.ssm.mapper;

import com.wtu.ssm.entity.User;

/**
 * Created by menglanyingfei on 2018/1/22.
 */
public interface UserMapper {
    User findUserById(Integer id);
}
