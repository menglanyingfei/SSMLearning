package com.wtu.spring.dao.annotation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 15:01
 */
/*
 * @Transactional加在类名上面: 表示该类中所有的方法都要加上事务
 * @Transactional：该注解一般写在service层中的实现类上
 */
//@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    /*
        Spring的Dao模块提供了JdbcTemplate
        该类中3个方法:
        update(String sql, Object... args) 增删改
        query(String sql, RowMapper rm, Object... args) 查询所有
        queryForObject          查询单个对象
     */
    @Resource
    private JdbcTemplate jt;

    @Transactional
    @Override
    public void addUser(Customer c) {
        String sql = "insert into `t_customer` values(?,?,?,?,?,?,?)";
        Object[] obj = {c.getId(),c.getName(),c.getGender(),
                c.getBirthday(),c.getCellphone(),c.getEmail(),c.getDescription()};
        jt.update(sql, obj);
    }

    @Override
    public void deleteUser(String id) {
        System.out.println("删除用户");
    }

    /**
     * 查询单个对象
     * rowMapper:是个接口
     */
    @Override
    public Customer findCustomer(String id) {
        String sql = "select * from `t_customer` where cid = ?";
        Object[] obj = {id};
        return jt.queryForObject(sql, new RowMapper<Customer>(){
            /*
             * rs:查询结果集
             * rowNum:表示当前结果集是第几行  0 表示第一行
             * 如果是单个对象  rowNum永远等于零
             * 下面这个方法表示循环遍历结果集   也就是不需要我们再去写while循环
             */
            public Customer mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
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
        }, obj);
    }

    @Override
    public List<Customer> findAllCustomer() {
        String sql = "select * from `t_customer` ";

        return jt.query(sql, new RowMapper<Customer>() {
            /*
			 * rs:查询结果集
			 * rowNum: 表示当前结果集是第几行, 0表示第一行
			 * 如果是单个对象, rowNum永远等于零
			 * 下面这个方法表示循环遍历结果集, 也就是不需要我们再去写while循环
			 */
            @Override
            public Customer mapRow(ResultSet rs, int j) throws SQLException {
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












