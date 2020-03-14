/**
 * 
 */
package com.mystarter.config;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

/**
 * @author liuwei 业务类
 */
@Data
public class HelloServer {

	@Autowired
	private MyConfig myConfig;

	public String sayHello(String name) {
		return myConfig.getPrefix() + "-" + name + " hello -" + myConfig.getSuffix();
	}

}
