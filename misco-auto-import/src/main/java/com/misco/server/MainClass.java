package com.misco.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author liuwei
 *
 */
@ExternalAnnotation //添加这个注解 自动import 外部配置类 
@Slf4j
public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainClass.class);
		User user = (User) ac.getBean("user");
		log.info(user.toString());
	}
}
