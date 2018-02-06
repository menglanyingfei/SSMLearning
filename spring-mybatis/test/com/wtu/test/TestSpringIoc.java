package com.wtu.test;

import com.wtu.ssm.dao.UserDao;
import com.wtu.ssm.dao.UserDaoImpl;
import com.wtu.ssm.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author menglanyingfei
 * Created on 2018.01.22 12:26
 */
public class TestSpringIoc {
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring3.0.xml");
    }

    @Test
    public void testFindUserById() {
        UserDao userDao = context.getBean(UserDaoImpl.class);
        User user = userDao.findUserById(28);
        System.out.println(user);
    }
}
