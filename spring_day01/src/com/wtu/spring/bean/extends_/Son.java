package com.wtu.spring.bean.extends_;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.16 14:51
 */
public class Son {
    private String id;
    private String name;
    private double salary;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Son{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
