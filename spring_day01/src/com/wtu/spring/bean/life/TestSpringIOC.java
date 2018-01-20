package com.wtu.spring.bean.life;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {

	public static void main(String[] args) throws Exception {
		
		//启动IOC容器  
		//ClassPathXmpApplicationContext(String... configLocations);
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("com/wtu/spring/bean/life/spring3.0.xml");
		/*
		    为什么在bean中配置了destroy-method, 但是还是不能够执行销毁的方法?
		    那是因为容器ApplicationContext不具备监听销毁的功能, 所以为了执行销毁, 得换一个容器
            AbstractApplicationContext
		 */
		// 监听销毁执行bean的销毁的方法, 该方法会立即执行bean的销毁方法

//        aac.close();
        // 监听销毁执行bean的销毁的方法, 该方法不会立即执行bean的销毁方法, 等到关闭JVM的
        // 那一刻才执行
        aac.registerShutdownHook();

		Thread.sleep(2000);
	}
}
