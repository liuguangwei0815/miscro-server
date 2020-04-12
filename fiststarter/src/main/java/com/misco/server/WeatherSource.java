/**
 * 
 */
package com.misco.server;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liuwei 定义天气
 */
@ConfigurationProperties(prefix = "weather")//读取配置文件中以weather开通的配置属性
public class WeatherSource {
	private String type;
	private String rate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
}
