/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class MiscoConfigApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoConfigApplication.class, args);
	}
}
