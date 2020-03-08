/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuwei
 *  1/依赖
 *  2、配置yml rabbit 和 stream 
 *  
 */
@SpringBootApplication
public class MiscoConsumerApplication  {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoConsumerApplication.class, args);
	}
}
