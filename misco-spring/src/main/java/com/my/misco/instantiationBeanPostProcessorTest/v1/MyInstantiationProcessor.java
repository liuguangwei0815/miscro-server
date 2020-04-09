package com.my.misco.instantiationBeanPostProcessorTest.v1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationProcessor implements InstantiationAwareBeanPostProcessor {
	
	private static CgLibProxyCar proxy = new CgLibProxyCar();

	// 构造前 执行，通过该方法返回代理对象 获取其他对象
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println(beanClass.getName() + "-beanName:" + beanName);
		try {
			return proxy.getInstance(beanClass.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}