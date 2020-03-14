/**
 * 
 */
package com.mystarter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuwei 将 HelloServer 自动装载进去
 */
@Configuration
@ConditionalOnWebApplication // 当这个引用的容器 为web项目才生效
@EnableConfigurationProperties(MyConfig.class) // 使MyConfig 里面引用配置文件的属性能引进来 1、定义 ConfigurationProperties 声明 2、然后enable//// 使之生效
public class HelloServiceAutoconfig {

	@Autowired
	private MyConfig myConfig;

	@Bean
	public HelloServer helloServer() {
		HelloServer hs = 	new  HelloServer();
		hs.setMyConfig(myConfig);
		return hs;
	}

}
