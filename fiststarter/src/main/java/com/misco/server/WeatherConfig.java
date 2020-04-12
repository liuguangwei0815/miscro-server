package com.misco.server;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WeatherSource.class)//将配置导入进来
//必须配置文件有weather.enable 而且 值必须是enbale 才能将这个该bean 注入到我们到我们ioc容器中
@ConditionalOnProperty(name = "weather.enable",havingValue = "enable")
public class WeatherConfig {
	
//	//将我们的配置源自动注入进来
//	@Autowired
//	private WeatherSource source;
	//当前类如果之前有了 不进行加入我们ico组件中
	@Bean
	@ConditionalOnMissingBean(WeatherServivce.class)
	public WeatherServivce weatherServivce(WeatherSource source) {
		return new  WeatherServivce(source);
	}
}
