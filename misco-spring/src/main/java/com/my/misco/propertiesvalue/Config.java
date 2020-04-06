package com.my.misco.propertiesvalue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.my.misco.propertiesvalue")
//可以指定多个配置文件
@PropertySource(value = {"classpath:/person.properties"})
public class Config {
	@Bean
	public Person person() {
		return new Person();
	}
}
