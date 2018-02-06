package com.wtu.mapper;

import com.wtu.pojo.QueryVo;
import com.wtu.pojo.User;
import com.wtu.pojo.UserCustomer;

import java.util.HashMap;
import java.util.List;

/**
 * mapper开发的接口
 * Created by menglanyingfei
 * on 2018/1/20.
 */
public interface UserMapper {
    // 根据姓名和性别统计人数, 采用QueryVo作为输入参数
    Integer findUserCount(QueryVo queryVo);
    // 根据id查询用户, 采用HashMap作为输出映射
    HashMap<String, Object> findUserById(Integer id);

    User findUserById2(Integer id);
    // 根据id查询用户, 采用ResultMap作为输出类型
    User findUserByResultMap(Integer id);

    // 根据性别和姓名查询用户信息, 如果没有输入查询条件, 则查询所有
    List<UserCustomer> findUserByUserNameAndSex(QueryVo queryVo);
    // 查询用户名中带小字, 性别为1, 用户id为28, 30的用户
    List<UserCustomer> findUserByUserNameAndSex2(QueryVo queryVo);


}
