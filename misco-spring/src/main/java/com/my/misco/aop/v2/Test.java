package com.my.misco.aop.v2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext aa = new AnnotationConfigApplicationContext(Config.class);
		Hello bean = (Hello) aa.getBean("hello");
		bean.hello();
	}

}
