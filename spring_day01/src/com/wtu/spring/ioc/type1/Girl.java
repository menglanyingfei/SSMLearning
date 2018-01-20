package com.wtu.spring.ioc.type1;

public class Girl {
	private String id;
	private String name;
	private Double salary;
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
