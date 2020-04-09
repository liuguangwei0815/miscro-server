package com.my.misco.instantiationBeanPostProcessorTest.v1;

import org.springframework.stereotype.Component;

@Component
public class Car1 {
	private String name = "car1";

	@Override
	public String toString() {
		return "Car1 [name=" + name + "]";
	}
	
}
