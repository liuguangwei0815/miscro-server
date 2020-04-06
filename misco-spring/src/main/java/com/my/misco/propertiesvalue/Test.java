package com.my.misco.propertiesvalue;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(Config.class);
		Person bean = an.getBean(Person.class);
		System.out.println("bean==>"+bean);
		String key = an.getEnvironment().getProperty("nikck");
		System.out.println("key==>"+key);
		an.close();
	}
}
