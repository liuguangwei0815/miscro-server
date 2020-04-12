/**
 * 
 */
package com.misco.server.beanfactorypostporcesor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 向Teacher 这个bean注入属性
 */
@Component
public class TeacherBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("teacher");
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		propertyValues.add("name", "wangwu");
	}
}
