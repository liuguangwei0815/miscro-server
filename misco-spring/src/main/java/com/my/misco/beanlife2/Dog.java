package com.my.misco.beanlife2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @PostConstruct 和 @PreDestroy 为什么他们能工作呢，我们debug看下
 * 
 * 
 * 
 * 
 * @author liuwei
 *
 */
@Component
public class Dog {
	public Dog() {
		System.out.println("Dog 创建");
	}

	@PostConstruct
	public void init() {
		System.out.println("Dog @PostConstruct");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Dog @PreDestroy");
	}
}
