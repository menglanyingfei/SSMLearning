package com.netease.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.netease.course.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author menglanyingfei
 * @date 2017-8-22
 */

@Repository
public class JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createTable() {
		jdbcTemplate
				.execute("create table user (id integer, firstName varchar(100), lastName varchar(100))");
	}

	public void insertData() {
		this.jdbcTemplate.update("insert into user values (1, ?, ?)", "mei",
				"Han");
		this.jdbcTemplate.update("insert into user values (2, ?, ?)", "lei",
				"Li");
	}

	public int count() {
		return this.jdbcTemplate.queryForObject("select count(*) from user",
				Integer.class);
	}

	public List<User> getUserList() {
		return this.jdbcTemplate.query("select * from user",
				new RowMapper<User>() {
					//@Override
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setFirstName(rs.getString("firstName"));
						user.setLastName(rs.getString("lastName"));

						return user;
					}
				});
	}
}
