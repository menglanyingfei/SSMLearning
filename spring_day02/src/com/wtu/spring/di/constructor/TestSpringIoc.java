package com.wtu.spring.di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:22
 */
public class TestSpringIoc {
    public static void main(String[] args) {
        // 启动IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/di/constructor/spring3.0.xml"}
        );

        Boy boy = (Boy) ac.getBean("boyId");
        System.out.println(boy);
        //Boy{id='001', name='小阳', age=16, salary=1000.0}
    }
}
