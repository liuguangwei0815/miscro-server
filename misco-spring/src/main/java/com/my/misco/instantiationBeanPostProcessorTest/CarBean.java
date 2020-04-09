//package com.my.misco.instantiationBeanPostProcessorTest;
//
//import java.beans.PropertyDescriptor;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.PropertyValues;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
//import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CarBean implements InstantiationAwareBeanPostProcessor,BeanPostProcessor,DestructionAwareBeanPostProcessor
//{
//
//	/**
//	 * 在实例化目标bean之前应用这个BeanPostProcessor。返回的bean对象可以是一个代替目标bean使用的代理，从而有效地抑制了目标bean的默认实例化。
//	 */
//	@Override
//	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//		System.out.println("postProcessBeforeInstantiation--->");
//		return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
//	}
//
//	/**
//	 * 通过构造函数或工厂方法实例化bean之后，但在Spring属性填充(来自显式属性或自动装配)发生之前执行操作。
//	 * 这是在Spring的自动装配开始之前，对给定beaninstance执行自定义字段注入的理想回调。 默认实现返回true。
//	 */
//	@Override
//	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessAfterInstantiation--->");
//		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
//	}
//
//	/**
//	 * 在工厂将给定的属性值应用到给定bean之前对它们进行后处理，而不需要任何属性描述符。
//	 * 如果实现提供了自定义的postProcessPropertyValues实现，则实现应该返回null(默认值)，否则返回pv。在这个接口的未来版本中(删除了postProcessPropertyValues)，默认实现将直接返回给定的pv。
//	 */
//	@Override
//	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
//			throws BeansException {
//		System.out.println("postProcessProperties--->");
//		return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
//	}
//
//	/**
//	 * 在工厂将给定的属性值应用到给定的bean之前，对它们进行后处理。允许检查是否满足了所有依赖项，例如基于bean属性设置器上的“Required”注释。
//	 */
//	@Override
//	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
//			String beanName) throws BeansException {
//		System.out.println("postProcessPropertyValues--->");
//		return pvs;
//	}
//
//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessBeforeInitialization--->");
//		return bean;
//	}
//
//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessAfterInitialization--->");
//		return bean;
//	}
//
//	@Override
//	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessBeforeDestruction--->");
//	}
//
//}
