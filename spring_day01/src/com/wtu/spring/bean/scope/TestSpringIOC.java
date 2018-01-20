package com.wtu.spring.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		//启动IOC容器  
		//ClassPathXmpApplicationContext(String... configLocations);
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wtu/spring/bean/scope/spring3.0.xml");

//		 spring IOC容器创建bean默认是单例模式
		IUserDao iUserDao = (IUserDao) ac.getBean("userDaoImpl");
		IUserDao iUserDao2 = (IUserDao) ac.getBean("userDaoImpl");
		System.out.println(iUserDao == iUserDao2);

//		System.out.println(iUserDao);
	}
}
