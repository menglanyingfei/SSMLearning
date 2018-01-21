package com.wtu.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */

public class UserDaoImpl implements UserDao {
    /*
        Spring的Dao模块提供了JdbcTemplate
        该类中三个方法:
        update(String sql, Object... args) 增删改
        query(String sql, RowMapper rm, Object... args)
        queryForObject 查询单个对象
     */
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(Customer customer) {
        String sql = "insert into `t_customer` values(?,?,?,?,?,?,?)";
        Object[] objects = {customer.getId(), customer.getName(), customer.getGender(),
            customer.getBirthday(), customer.getCellphone(), customer.getEmail(), customer.getDescription()};

        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void deleteUser(String id) {
        System.out.println("删除用户");
    }

    /*
        查询单个对象, RowMapper是个接口
     */
    @Override
    public Customer findCustomer(String id) {
        String sql = "select * from `t_customer` where cid = ?";
        Object[] objects = {id};
        return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {
            /*
			 * rs:查询结果集
			 * rowNum: 表示当前结果集是第几行, 0表示第一行
			 * 如果是单个对象, rowNum永远等于零
			 * 下面这个方法表示循环遍历结果集, 也就是不需要我们再去写while循环
			 */
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                System.out.println("rowNum = " + i);
                //手工及解析结果集  封装Customer对象
                Customer c = new Customer();
                c.setId(rs.getString(1));
                c.setName(rs.getString(2));
                c.setGender(rs.getString(3));
                c.setBirthday(rs.getDate(4));
                c.setCellphone(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setDescription(rs.getString(7));
                return c;
            }

        }, objects);
    }

    @Override
    public List<Customer> findAllCustomer() {
        String sql = "select * from `t_customer` ";

        return jdbcTemplate.query(sql, new RowMapper<Customer>() {
            /*
			 * rs:查询结果集
			 * rowNum: 表示当前结果集是第几行, 0表示第一行
			 * 如果是单个对象, rowNum永远等于零
			 * 下面这个方法表示循环遍历结果集, 也就是不需要我们再去写while循环
			 */
            @Override
            public Customer mapRow(ResultSet rs, int j) throws SQLException {
                System.out.println(j);

                //手工解析结果集  封装Customer对象
                Customer c = new Customer();
                c.setId(rs.getString(1));
                c.setName(rs.getString(2));
                c.setGender(rs.getString(3));
                c.setBirthday(rs.getDate(4));
                c.setCellphone(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setDescription(rs.getString(7));
                return c;
            }
        });
    }
}





















