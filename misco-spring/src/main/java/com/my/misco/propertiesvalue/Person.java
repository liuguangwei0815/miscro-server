package com.my.misco.propertiesvalue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @PostConstruct 和 @PreDestroy 为什么他们能工作呢，我们debug看下
 * 
 * 
 * 
 * 
 * @author liuwei
 *
 */
@Data
public class Person {
	/**
	 * 1、设置默认值 2、spel #{} 3、${} 获取属性值
	 */
	// 默认值
	@Value("jack")
	String userName;
	// spel
	@Value("#{20-2}")
	int age;
	// 读取配置文件
	@Value("${nikck}")
	String nick;
	// 读取配置文件
	@Value("${nikck.jjj}")
	String nickk;
}
