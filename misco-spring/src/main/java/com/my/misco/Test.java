/**
 * 
 */
package com.my.misco;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.misco.config.BeanConfig;

/**
 * @author liuwei
 *
 */
public class Test {

	public static void main(String[] args) {
		//一种方式获取Bean 1、配置问价
//		ClassPathXmlApplicationContext xxx = new ClassPathXmlApplicationContext("beans.xml");
//		Person person = (Person) xxx.getBean("person");
//		System.out.println(person);
		//第二周使用注解方式
		AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(BeanConfig.class);
		Person  person=	acp.getBean(Person.class);
		System.out.println(person);
		String[] beanNamesForType = acp.getBeanNamesForType(Person.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
		
	}

}
 