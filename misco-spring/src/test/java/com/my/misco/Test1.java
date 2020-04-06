package com.my.misco;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.my.misco.config.BeanConfig;
import com.my.misco.config.BeanConfig2;
import com.my.misco.factorybean.MyFactoryBean;

public class Test1 {

	@Test
	public void testFactoryBean() {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(BeanConfig2.class);
		MyFactoryBean bean = an.getBean(MyFactoryBean.class);
		System.out.println("这个什么类型1："+bean.getClass());
		Object bean2 = an.getBean("myFactoryBean");
		System.out.println("这个什么类型2："+bean2.getClass());
		Object bean3 = an.getBean("&myFactoryBean");
		System.out.println("这个什么类型3："+bean3.getClass());
	}

	// condition, 需求，通过不同系统注册不同的bean
	@Test
	public void test2() {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(BeanConfig2.class);
		String[] beanDefinitionNames = an.getBeanDefinitionNames();
		for (String str : beanDefinitionNames) {
			System.out.println(str);
		}
		// 打印他们的具体信息
		Map<String, Person> beansOfType = an.getBeansOfType(Person.class);
		for (Entry<String, Person> en : beansOfType.entrySet()) {
			System.out.println(en.getValue());
		}
	}

	@Test
	public void test1() {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(BeanConfig2.class);
	}

	@Test
	public void test() {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(BeanConfig.class);
		String[] cc = an.getBeanDefinitionNames();
		for (String string : cc) {
			System.out.println(string);
		}
	}
}
