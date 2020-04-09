package com.my.misco.instantiationBeanPostProcessorTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new	AnnotationConfigApplicationContext(Config.class);
		System.out.println("容器建立完毕");
		a.close();
	}
}
