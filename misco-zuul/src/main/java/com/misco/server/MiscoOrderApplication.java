/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
//开启zuul网关
@EnableZuulProxy
//开启eureka
@EnableEurekaClient
public class MiscoOrderApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoOrderApplication.class, args);
	}
}
