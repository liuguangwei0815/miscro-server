package com.misco.server.initzer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

@Order(3)
public class MyInitiazer3 implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		Map<String, Object> prop = new HashMap<String, Object>(); 
		prop.put("key3", "333");
		propertySources.addLast(new MapPropertySource("thirdEnv3", prop));
		System.out.println("系统初始化器3");
	
		//设置一个必备的属性
		environment.setRequiredProperties("mook");
		
	}
}
