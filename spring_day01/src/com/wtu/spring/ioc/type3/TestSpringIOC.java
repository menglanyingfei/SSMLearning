package com.wtu.spring.ioc.type3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		// 启动IOC容器
		// ClassPathXmpApplicationContext(String... configLocations);
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wtu/spring/ioc/type3/spring3.0.xml");
		Boy boy = (Boy) ac.getBean("boyId");
		System.out.println(boy);
	}
}
