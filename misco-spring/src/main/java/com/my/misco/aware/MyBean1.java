package com.my.misco.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import lombok.Getter;
import lombok.Setter;

/**
 * 他想获取ioc的上下文，字符串解析器（比尔spring的spel，${}）,bean的名称
 * @author liuwei
 */
@Component
public class MyBean1 implements ApplicationContextAware {
	@Setter
	@Getter
	private ApplicationContext applicationContext;
	//获取ioc的上下文
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("IOC的上下文："+applicationContext);
		this.applicationContext = applicationContext;
	}
}
