/**
 * 
 */
package com.my.misco.beanlife3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 *
 *原理：
 *	1、ioc ，启动方法refresh （1、初始化单例非懒加载的bean， 在获取的时候有利用的容器单例模式（DefaultSingletonBeanRegistry类），）
 *  2、执行popurateBean：给bean给属性赋值 ，
 *  initializeBean{
 *  3、执行appbeanPostProcessorBefroeInitztion
 *  4、执行初始化方法
 *  5、执行appliyBeanPostProcessoreafterInitization
 *  }
 *  
 *  ApplicationContextAware:可以将我们的spirng的上下文给获取到
 *  
 */
@Component
public class Horse implements BeanPostProcessor,ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**1、这个方法在@bean （init destroy） @postconstruct @predestroy,initializingbean,disposableam 之前直接
	** 2、可以返回刚刚建立的bean 对象 或者封装后的bean对象
	**/
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Horse - postProcessBeforeInitialization beanName："+beanName+" obj:"+bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Horse - postProcessAfterInitialization beanName："+beanName+" obj:"+bean);
		return bean;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//将上下文的给赋值给了当前的bean
		System.out.println("获取了spring的双下文对象："+applicationContext);
		this.applicationContext = applicationContext;
	}
}
