//package com.misco.server.work;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * 如果这个继承了InstantiationAwarePostProcessor
// * @author liuwei
// *
// */
//@Component
//public class MyInstantiationAwarePostProcessor implements InstantiationAwareBeanPostProcessor{
//
//	/**
//	 * @Nullable
//	protected Object applyBeanPostProcessorsBeforeInstantiation(Class<?> beanClass, String beanName) {
//		for (BeanPostProcessor bp : getBeanPostProcessors()) {
//			if (bp instanceof InstantiationAwareBeanPostProcessor) {
//				InstantiationAwareBeanPostProcessor ibp = (InstantiationAwareBeanPostProcessor) bp;
//				Object result = ibp.postProcessBeforeInstantiation(beanClass, beanName);
//				if (result != null) {
//					return result;
//				}
//			}
//		}
//		return null;
//	}源码知道 如果这个方法的返回值不为空 那么这个对象是直接这个方法返回的
//	 */
//	@Override
//	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//		if(StringUtils.equals("work", beanName)) {
//			return new Work();
//		}
//		return null;
//	}
//
//	//给这个bean赋值呀 等操作
//	@Override
//	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		
//		System.out.println("beanName:===>"+beanName);
//		if(StringUtils.equals("work", beanName)) {
//			Work work = (Work) bean;
//			work.setName("wangwu");
//		}
//		return true;
//	}
//	
//	
//
//	
//	
//}
