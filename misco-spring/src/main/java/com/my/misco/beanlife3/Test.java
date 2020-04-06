package com.my.misco.beanlife3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(Configbeanlife3.class);
		an.close();
	}

}
