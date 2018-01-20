package com.wtu.spring.di.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:22
 */
public class TestSpringIoc {
    public static void main(String[] args) throws Exception {
        // 启动IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/di/set/spring3.0.xml"}
        );

        Boy boy = (Boy) ac.getBean("boy");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-12"));
        //Tue Dec 12 00:00:00 CST 2017
        System.out.println(boy);
        //Boy{id='null', name='null', birthday=Tue Dec 12 00:00:00 CST 2017, age=null, salary=null}
    }
}
