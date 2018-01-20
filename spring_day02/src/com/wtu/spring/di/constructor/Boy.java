package com.wtu.spring.di.constructor;

import java.util.Date;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:13
 */
public class Boy {
    private String id;
    private String name;
    private Integer age;
    private Double salary;

    public Boy(String id, String name, Integer age, Double salary) {
        System.out.println("IOC容器创建对象");
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
