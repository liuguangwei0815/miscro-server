/**
 * 
 */
package com.my.misco.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuwei
 *
 */
@Configuration
@ComponentScan("com.my.misco.ext")
public class Config {
	@Bean
	public TestBean testBean() {
		return new TestBean();
	}
}
