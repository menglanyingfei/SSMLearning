package com.wtu.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.18 16:28
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    // 一个用户包括多个订单
    List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", birthday="
                + birthday + ", sex=" + sex + ", address=" + address + "]";
    }
}
