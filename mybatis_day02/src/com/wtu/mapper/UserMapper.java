package com.wtu.mapper;

import com.wtu.entity.QueryVo;
import com.wtu.entity.User;
import com.wtu.entity.UserCustomer;

import java.util.HashMap;
import java.util.List;

/**
 * mapper开发的接口
 * Created by menglanyingfei
 * on 2018/1/20.
 */
public interface UserMapper {
    List<User> findUserByName(String name);
    // 添加用户
    void insertUser(User user);

    // 根据用户的姓名和性别查询用户的信息, 采用包装类型作为输入参数
    List<UserCustomer> findUserByNameAndSex(QueryVo queryVo);

    List<UserCustomer> findUserByHashMap(HashMap hashMap);
}
