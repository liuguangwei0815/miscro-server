package com.my.misco.beanpostprocessor;

import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

import lombok.Data;

@Component
@Data
public class Fuck extends BeanValidationPostProcessor{
	@Override
	protected void doValidate(Object bean) {
		System.out.println("校验获取bean："+bean);
	}
}
