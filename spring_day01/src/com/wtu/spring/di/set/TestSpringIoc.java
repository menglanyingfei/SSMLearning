package com.wtu.spring.di.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 16:21
 */
public class TestSpringIoc {

    @Deprecated
    public static void main(String[] args) {
        // 启动容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"com/wtu/spring/di/set/spring3.0.xml"}
        );

        Customer customer = (Customer) ac.getBean("customer");
        System.out.println(customer.getId() + "--" + customer.getName());
        System.out.println(customer.getBirthday().toLocaleString());

        for (String addr : customer.getAddress()) {
            System.out.println(addr);
        }
        for (String phone : customer.getPhone()) {
            System.out.println(phone);
        }
        for (Map.Entry entry : customer.getAdd_pho().entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
















