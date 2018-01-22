package com.netease.course;
/**
 * @author menglanyingfei
 * @date 2017-8-17
 */
public class StraightHeader implements Header {
	private String color;
	private int size;

	public StraightHeader(String color, int size) {
		this.color = color;
		this.size = size;
	}

	public void doWork() {
		System.out.println("Do work with straight header");
	}

	public String getInfo() {
		return "StraightHeader: color=" + color + ", size=" + size;
	}

}
