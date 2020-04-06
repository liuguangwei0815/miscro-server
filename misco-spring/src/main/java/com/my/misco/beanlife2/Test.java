package com.my.misco.beanlife2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(ConfigBeanlife2.class);
		an.close();
	}
}
