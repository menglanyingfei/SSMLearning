package com.wtu.pojo;

import java.util.Date;
import java.util.List;

/**
 * Author menglanyingfei
 * Created on 2018.01.21 11:21
 */
public class Orders {
    private Integer id;
    private Integer user_id;
    private Integer number;
    private Date createtime;
    private String note;

    // 封装用户信息
    private User user;

    // 封装订单明细的信息
    private List<Orderdetail> odlist;

    public List<Orderdetail> getOdlist() {
        return odlist;
    }

    public void setOdlist(List<Orderdetail> odlist) {
        this.odlist = odlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", number=" + number +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
