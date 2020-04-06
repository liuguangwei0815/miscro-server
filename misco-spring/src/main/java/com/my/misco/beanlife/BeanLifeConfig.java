package com.my.misco.beanlife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLifeConfig {
	//通过bean执行类的初始化方法和销毁方法，多利destroyMetohd ioc不进行管理
	@Bean(initMethod = "init",destroyMethod = "destrory")
	public Car car() {
		return new Car();
	}
}
