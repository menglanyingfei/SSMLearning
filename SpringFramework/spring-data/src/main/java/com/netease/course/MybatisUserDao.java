package com.netease.course;

import java.util.List;

import com.netease.course.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author menglanyingfei
 * @date 2017-8-23
 */
public interface MybatisUserDao {
	// 添加映射
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "firstName", column = "firstName"),
			@Result(property = "lastName", column = "lastName") })
	@Select("select * from user where firstName=#{firstName}")
	public User getUser(String firstName);

	// 添加映射
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "firstName", column = "firstName"),
			@Result(property = "lastName", column = "lastName") })
	@Select("Select * from user")
	public List<User> getUserList();
}
