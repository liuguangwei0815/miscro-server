/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
@Configuration
public class MiscoConsulOrderApplication {
	//将restTemplte 交个spring管理
	@Bean
	@LoadBalanced //consul 也可以通过ribbon 进行负载
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoConsulOrderApplication.class, args);
	}
}
