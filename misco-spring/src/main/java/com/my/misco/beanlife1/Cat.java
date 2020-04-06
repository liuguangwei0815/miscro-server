package com.my.misco.beanlife1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean,DisposableBean{
	public Cat() {
		System.out.println("cat 创建");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("销毁方法");
	}
	//类初始化完毕，并且属性已经配置好了就可以了
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化。。。afterPropertiesSet");
	}
}
