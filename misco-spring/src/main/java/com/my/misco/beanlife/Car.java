package com.my.misco.beanlife;

public class Car {
	public Car() {
		System.out.println("car创建");
	}
	//初始化方法
	public void init() {
		System.out.println("car init....");
	}
	//销毁方法，单例执行这个销毁方法，多利不会 他的生命周期ioc不进行管理
	public void destrory() {
		System.out.println("car destroy....");
	}
}
