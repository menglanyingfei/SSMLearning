package com.wtu.dao;

import com.wtu.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.20 10:30
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void addUser(User user) throws Exception {
        SqlSession session = factory.openSession();
        session.insert("demo.insertUser", user);
        session.commit();
        session.close();
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        SqlSession session = factory.openSession();
        session.delete("demo.deleteById", id);
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) throws Exception {
        SqlSession session = factory.openSession();
        session.update("demo.updateUser", user);
        session.commit();
        session.close();
    }

    @Override
    public User findUserById(Integer id) throws Exception {
        // 获取SqlSession对象
        SqlSession session = factory.openSession();
        User user = session.selectOne("demo.findUserById", id);
        return user;
    }

    @Override
    public List<User> findAllUser() throws Exception {
        SqlSession session = factory.openSession();
        List<User> userList = session.selectList("demo.findAllUser");
        return userList;
    }
}














