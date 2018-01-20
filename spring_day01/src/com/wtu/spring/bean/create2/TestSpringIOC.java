package com.wtu.spring.bean.create2;

import com.wtu.spring.bean.create.Boy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		//启动IOC容器  
		//ClassPathXmpApplicationContext(String... configLocations);
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wtu/spring/bean/create2/spring3.0.xml");
		IUserDao iUserDao = (IUserDao) ac.getBean("userDaoId");
		System.out.println(iUserDao);
	}
}
