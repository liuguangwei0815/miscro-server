package com.my.misco.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext aa = new AnnotationConfigApplicationContext(Config.class);
		aa.publishEvent(new ApplicationEvent(new PublicEvvv()) {
		});
	}
}
