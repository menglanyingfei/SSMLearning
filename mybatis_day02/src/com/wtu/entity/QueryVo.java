package com.wtu.entity;

/**
 * 自定义包装类, 封装所有的查询条件
 * Author menglanyingfei
 * Created on 2018.01.20 16:27
 */
public class QueryVo {
    // 封装用户信息
    private UserCustomer userCustomer;
    // 封装商品信息
    // private Items items;

    public UserCustomer getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(UserCustomer userCustomer) {
        this.userCustomer = userCustomer;
    }

}
