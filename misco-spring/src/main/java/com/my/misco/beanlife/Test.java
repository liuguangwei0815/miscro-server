package com.my.misco.beanlife;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(BeanLifeConfig.class);
		System.out.println("ioc容器启动成功");
		// 容器进行关闭,之前会执行destroy方法，多利不会
		an.close();
		System.out.println("ioc容器关闭成功");
	}

}
