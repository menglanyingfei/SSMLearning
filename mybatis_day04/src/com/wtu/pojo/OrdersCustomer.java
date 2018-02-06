package com.wtu.pojo;

/**
 * Author menglanyingfei
 * Created on 2018.01.21 11:25
 */
public class OrdersCustomer extends Orders {
    // 封装用户信息
    private String username;
    private String sex;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
