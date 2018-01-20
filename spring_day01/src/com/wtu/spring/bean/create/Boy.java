package com.wtu.spring.bean.create;

public class Boy {
    private String id;
    private String name;
    private Double salary;

    public Boy() {
        System.out.println("spring容器创建对象");
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Boy [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
