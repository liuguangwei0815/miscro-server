package com.my.misco.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("IOC容器启动完毕");
	}
}
