package com.my.misco.beanpostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(Config.class);
		an.close();
	}
	
}
