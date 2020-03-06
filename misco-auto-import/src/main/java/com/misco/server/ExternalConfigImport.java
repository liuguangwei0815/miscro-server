/**
 * 
 */
package com.misco.server;

import org.springframework.context.annotation.Bean;

/**
 * @author liuwei
 * 外部配置类 ，这里没有添加spring的注解@configuration 
 */
public class ExternalConfigImport {
	//因为没有在类头加上@configuration 或者 没有通过classForName 和 classLoander（） 他不会自我加载进sprng 容器中 这个 User对象
	@Bean
	public User user() {
		return new User("jack",18);
	}
}
