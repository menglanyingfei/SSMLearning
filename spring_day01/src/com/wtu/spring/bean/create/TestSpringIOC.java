package com.wtu.spring.bean.create;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		// 启动IOC容器
		// ClassPathXmpApplicationContext(String... configLocations);
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wtu/spring/bean/create/spring3.0.xml");
		Boy boy = (Boy) ac.getBean("boyId");
		System.out.println(boy);
	}
}
