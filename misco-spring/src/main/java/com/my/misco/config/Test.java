/**
 * 
 */
package com.my.misco.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liuwei
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(BeanConfig.class);
		String[] beanDefinitionNames = an.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println("beanName:"+string);
		}
	}

}
