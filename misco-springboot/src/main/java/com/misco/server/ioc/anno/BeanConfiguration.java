package com.misco.server.ioc.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {MathBookImportBeanDefinitionRegistrar.class})
public class BeanConfiguration {
	@Bean
	public Book dog() {
		return new JavaBook();
	}
}
