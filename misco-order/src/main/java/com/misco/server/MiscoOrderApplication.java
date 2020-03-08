/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
@Configuration
//不用注解启动eureka 客户端也可以
@EnableEurekaClient
//开启Feign注解
@EnableFeignClients
//开启熔断
//@EnableCircuitBreaker//电子熔断器 @EnableHystrix  都可以
@EnableHystrix
//开启hystrix的bashboard
@EnableHystrixDashboard
public class MiscoOrderApplication {
	//将restTemplte 交个spring管理
	@Bean
	@LoadBalanced //eureka 内部集成了 ribbon 这个开启ribbon
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoOrderApplication.class, args);
	}
}
