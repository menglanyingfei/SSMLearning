package com.wtu.test;

import com.wtu.ssm.entity.User;
import com.wtu.ssm.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author menglanyingfei
 * Created on 2018.01.22 14:22
 */
public class testUserMapper {
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring3.0.xml");
    }

    @Test
    public void findUserById() {
        // 获取Mapper接口的代理对象
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.findUserById(28);

        System.out.println(user);
    }
}
