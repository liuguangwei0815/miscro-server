package com.my.misco.beanlife3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class HorseJSR250 {
	public HorseJSR250() {
		System.out.println("HorseJSR250 create");
	}
	@PostConstruct
	public void init() {
		System.out.println("HorseJSR250 postconstruct");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("HorseJSR250 destroy");
	}
}
