package com.my.misco.aop.v1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(Config.class);
		Caculator bean = an.getBean(Caculator.class);
		bean.cacu(8, 8);
		//bean.cacu(3, 0);
	}
}
