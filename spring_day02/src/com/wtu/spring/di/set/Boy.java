package com.wtu.spring.di.set;

import java.util.Date;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.17 14:13
 */
public class Boy {
    private String id;
    private String name;
    private Integer age;
    private Date birthday;
    private Double salary;

    public Boy() {
        System.out.println("Ioc容器创建对象");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
