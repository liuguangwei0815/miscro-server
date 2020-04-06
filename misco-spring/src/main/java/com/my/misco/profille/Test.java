package com.my.misco.profille;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		//不能是有有参数构造的ioc，需要无参数的，以为有参数的是，registr（配置） ，然后reflush（启动）
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext();
		//你设置的容器
		an.getEnvironment().setActiveProfiles("test");
		//加载配置文件
		an.register(MyDataSorue.class);
		//启动
		an.refresh();
		
		String[] beanNamesForType = an.getBeanNamesForType(DataSource.class);
		for (String string : beanNamesForType) {
			System.out.println("BeanName:"+string);
		}
	}
}
