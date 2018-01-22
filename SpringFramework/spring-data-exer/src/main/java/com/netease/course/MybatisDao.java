package com.netease.course;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author menglanyingfei
 * @date 2017-8-27
 */

public interface MybatisDao {
    @Update("UPDATE account SET balance=balance+#{param1} WHERE user=#{param2} ")
    public void addMoney(double count, String targetUser);

    @Update("UPDATE account SET balance=balance-#{param1} WHERE user=#{param2} ")
    public void subMoney(double count, String srcUser);

    @Select("SELECT * FROM account")
    public List<UserBalance> findAll();
}
