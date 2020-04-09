package com.my.misco.instantiationBeanPostProcessorTest.v1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("com.my.misco.instantiationBeanPostProcessorTest.v1")
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(Test.class);
		System.out.println(a.getBean(Car1.class).toString());
	}

}
