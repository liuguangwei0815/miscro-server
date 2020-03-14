/**
 * 
 */
package com.mystarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author liuwei 配置信息类
 */
@ConfigurationProperties(prefix = "my.hello") // 绑定配置文件的属性 以my.hello 开头的属性配置
@Data
public class MyConfig {

	private String prefix;// 前缀
	private String suffix;// 后缀

}
