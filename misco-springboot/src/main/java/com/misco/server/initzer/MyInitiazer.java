package com.misco.server.initzer;

import java.util.Properties;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

//通过spring.factories 注册bean 到容器中\
@Order(1)
public class MyInitiazer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		Properties prop = new Properties();
		//这个是环境的key值  不是下面那个
		prop.put("key1", "111");
		propertySources.addLast(new PropertiesPropertySource("thirdEnv1", prop));
		System.out.println("系统初始化器1");
	}
}
