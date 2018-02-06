package com.wtu.ssm.dao;

import com.wtu.ssm.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Author menglanyingfei
 * Created on 2018.01.22 10:13
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
//    private SqlSessionFactory factory;
//
//    public void setFactory(SqlSessionFactory factory) {
//        this.factory = factory;
//    }

    @Override
    public User findUserById(Integer id) {
//        SqlSession session = factory.openSession();
        SqlSession session = this.getSqlSession();
        User user = session.selectOne("demo.findUserById", 28);
        return user;
    }
}
