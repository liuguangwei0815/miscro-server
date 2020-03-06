/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
@EnableEurekaServer//开启eureka主从服务中心
public class MiscoEurekaServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MiscoEurekaServerApplication.class, args);
	}

}
