package com.wtu.spring.ioc.type2;

public class Girl {
	private String id;
	private String name;
	private Double salary;
	public Girl(){
		System.out.println("spring容器创建girl对象");
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
		return "Girl [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
