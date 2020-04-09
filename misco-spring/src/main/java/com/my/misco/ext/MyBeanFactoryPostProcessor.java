package com.my.misco.ext;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	//该方法在调用对象实例化前调用
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("多少个bean"+beanFactory.getBeanDefinitionCount());
		System.out.println("多少个beanName"+Arrays.asList(beanFactory.getBeanDefinitionNames()));
	}

}
