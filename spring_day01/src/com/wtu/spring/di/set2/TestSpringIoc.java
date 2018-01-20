package com.wtu.spring.di.set2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 16:21
 */
public class TestSpringIoc {

    public static void main(String[] args) {
        // 启动容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/di/set2/spring3.0.xml"}
        );

        Customer customer = (Customer) ac.getBean("customer");

        for (Addr addr : customer.getAddress()) {
            System.out.println(addr.getName());
        }

        for (Phone phone : customer.getPhone()) {
            System.out.println(phone.getNumber());
        }

        for (Map.Entry<Addr, Phone> e : customer.getAdd_pho().entrySet()) {
            System.out.println(e.getKey() + "-->" + e.getValue());
        }
    }
}
















