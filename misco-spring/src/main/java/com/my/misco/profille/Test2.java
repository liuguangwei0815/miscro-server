package com.my.misco.profille;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(MyDataSorue.class);
		String[] beanNamesForType = an.getBeanNamesForType(DataSource.class);
		for (String string : beanNamesForType) {
			System.out.println("BeanName:"+string);
		}
	}
}
