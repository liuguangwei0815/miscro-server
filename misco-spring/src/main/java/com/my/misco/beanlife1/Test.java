package com.my.misco.beanlife1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(ConfigBeanlife1.class);
		an.close();
	}
}
