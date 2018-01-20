package com.wtu.spring.di.set;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 16:08
 */
public class Customer {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Date birthday;
    private List<String> address;
    private Set<String> phone;
    private Map<String, String> add_pho;

    public Customer() {
        System.out.println("IOC 创建对象!");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }

    public Map<String, String> getAdd_pho() {
        return add_pho;
    }

    public void setAdd_pho(Map<String, String> add_pho) {
        this.add_pho = add_pho;
    }
}
