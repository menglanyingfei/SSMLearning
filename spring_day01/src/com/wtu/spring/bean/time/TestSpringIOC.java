package com.wtu.spring.bean.time;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		//启动IOC容器  
		//ClassPathXmpApplicationContext(String... configLocations);
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wtu/spring/bean/time/spring3.0.xml");

//        IUserDao iUserDao = (IUserDao) ac.getBean("IUserDao");

	}
}
