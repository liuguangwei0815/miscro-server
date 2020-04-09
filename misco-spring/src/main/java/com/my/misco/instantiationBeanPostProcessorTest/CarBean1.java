package com.my.misco.instantiationBeanPostProcessorTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class CarBean1 {
	
	public CarBean1() {
		System.out.println("create CarBean1");
	}
	
	@PostConstruct
	public void initt() {
		System.out.println("CarBean1@PostConstruct");
	}
	
	@PreDestroy
	public void dest() {
		System.out.println("CarBean1@PreDestroy");
	}
}
