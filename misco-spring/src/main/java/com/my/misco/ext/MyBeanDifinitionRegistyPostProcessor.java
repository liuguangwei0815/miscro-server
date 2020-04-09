/**
 * 
 */
package com.my.misco.ext;

import org.assertj.core.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 1、BeanFacotry 的 子类 他是在他之前执行，他定义的信息都是会到BeanFactory 加载的
 * 2、先执行这个子类才会执行外面的BeanFacotryPostProcessor
 */
@Component
public class MyBeanDifinitionRegistyPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("多少个bean"+beanFactory.getBeanDefinitionCount());
		System.out.println("多少个beanName"+Arrays.asList(beanFactory.getBeanDefinitionNames()));
	}
	//这个是在BeanFacotry前执行，他是bean的定义中心，facory是按照他来实例化对象的
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("多少个bean"+registry.getBeanDefinitionCount());
		System.out.println("多少个beanName"+Arrays.asList(registry.getBeanDefinitionNames()));
		//我有自己组成了一个beabs
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(BeanDefinitionRegistryPostProcessBean.class).getBeanDefinition();
		registry.registerBeanDefinition("dipob", beanDefinition);
	}
}
