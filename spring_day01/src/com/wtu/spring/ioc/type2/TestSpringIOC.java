package com.wtu.spring.ioc.type2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		//启动IOC容器  
		//FileSystemXmlApplicationContext(String... configLocations);
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				new String[]{"src/com/wtu/spring/ioc/type2/boy.xml",
						"src/com/wtu/spring/ioc/type2/girl.xml"});
		/*
		 * 1.启动容器的时候会不会创建对象  启动容器默认会创建对象
		 * 2.如果创建  那么先创建谁   根据配置文件的书写顺序创建对象
		 */
	}
}
