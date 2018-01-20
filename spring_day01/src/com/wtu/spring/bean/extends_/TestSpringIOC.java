package com.wtu.spring.bean.extends_;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		//启动IOC容器  
		//ClassPathXmpApplicationContext(String... configLocations);
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wtu/spring/bean/extends_/spring3.0.xml");

		Son son = (Son) ac.getBean("sonId");
		System.out.println(son);
		//Son{id='002', name='曹丕', salary='1000000.0'}
	}
}
