package com.wtu.spring.ioc.type1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		//启动IOC容器  
		//FileSystemXmlApplicationContext(String... configLocations);
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				new String[]{"src/com/wtu/spring/ioc/type1/spring3.0.xml"});
		
		Boy boy = (Boy) ac.getBean("boyId");
		System.out.println(boy);
	}
}
