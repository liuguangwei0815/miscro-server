/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
//开启eureka
@EnableEurekaClient
public class MiscoGetWayApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoGetWayApplication.class, args);
	}
}
