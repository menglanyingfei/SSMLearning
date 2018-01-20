package com.wtu.spring.di.set2;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 16:08
 */
public class Customer {
    private List<Addr> address;
    private Set<Phone> phone;
    private Map<Addr, Phone> add_pho;

    public Customer() {
        System.out.println("IOC 创建对象!");
    }

    public List<Addr> getAddress() {
        return address;
    }

    public void setAddress(List<Addr> address) {
        this.address = address;
    }

    public Set<Phone> getPhone() {
        return phone;
    }

    public void setPhone(Set<Phone> phone) {
        this.phone = phone;
    }

    public Map<Addr, Phone> getAdd_pho() {
        return add_pho;
    }

    public void setAdd_pho(Map<Addr, Phone> add_pho) {
        this.add_pho = add_pho;
    }
}
