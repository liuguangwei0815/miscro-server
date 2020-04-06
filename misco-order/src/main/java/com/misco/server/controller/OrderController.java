/**
 * 
 */
package com.misco.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.misco.server.dto.TbProduct;
import com.misco.server.feign.ProductFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuwei
 *
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	
	@Value("${name:UNKONE}")
	private String name;
	
	// 通过
	@Autowired
	private DiscoveryClient discoveryClient;

	// 通过地址 但是不好维护 地址是可变化的
	@Autowired
	private RestTemplate restTemplate;

	// 通过feign 进行服务调用
	@Autowired
	private ProductFeign productFeign;
	
	
	@GetMapping("/test")
	public String teee() {
		System.out.println("我是小明");
		this.name = "Iam jack hhh";
		return name;
	}

	@GetMapping("/buy/{id:\\d+}")
	public TbProduct getTbProduct(@PathVariable Long id) {
		return restTemplate.getForObject("http://localhost:7046/product/1", TbProduct.class);
	}

	// 通过元数据进行获取地址
	@GetMapping("/buy/dis/{id:\\d+}")
	public TbProduct getdiscoveryTbProduct(@PathVariable Long id) {
		ServiceInstance ss = discoveryClient.getInstances("misco-product").get(0);
		String url = "http://" + ss.getHost() + ":" + ss.getPort();
		log.info("获取地址：" + url);
		return restTemplate.getForObject(url + "/product/1", TbProduct.class);
	}

	// 进行ribbon进行调度
	@GetMapping("/buy/ribbon/{id:\\d+}")
	public TbProduct getribbon(@PathVariable Long id) {
		String serviceName = "misco-product";
		return restTemplate.getForObject("http://" + serviceName + "/product/1", TbProduct.class);
	}

	// 重试机制 id 为服务休眠时间
	@GetMapping("/buy/retry/{id:\\d+}")
	public TbProduct retry(@PathVariable Long id) {
		String serviceName = "misco-product";
		return restTemplate.getForObject("http://" + serviceName + "/product/retry/" + id, TbProduct.class);
	}

	// 进行ribbon进行调度
	@GetMapping("/buy/feign/{id:\\d+}")
	public TbProduct feign(@PathVariable Long id) {
		return productFeign.findById(id);
	}

	// 进行模拟并发 当请求线程数大于容器的最大线程数，出现的服务器不可用现象 记得 temlate 不能添加ribbon注解 否者请求不了
	@GetMapping("/buy/bf/{id:\\d+}")
	public String bing1(@PathVariable Long id) {
		return "只返回字符串";
	}

	// 进行模拟并发 当请求线程数大于容器的最大线程数，出现的服务器不可用现象 记得 temlate 不能添加ribbon注解 否者请求不了
	// 如果添加了ribbon 复制 需要通过注册中心进行
	@GetMapping("/buy/bf1/{id:\\d+}")
	public TbProduct bing2(@PathVariable Long id) {
		return restTemplate.getForObject("http://localhost:7046/product/wait/1", TbProduct.class);
	}

	// 进行Hystrix
	@GetMapping("/buy/hystrix/{id:\\d+}")
	@HystrixCommand(fallbackMethod = "ghystrixfallbackMethod")
	public TbProduct ghystrix(@PathVariable Long id) {
		String serviceName = "misco-product";
		return restTemplate.getForObject("http://" + serviceName + "/product/wait/1", TbProduct.class);
	}

	public TbProduct ghystrixfallbackMethod(@PathVariable Long id) {
		return new TbProduct("这是降级内容提示");
	}

	// feign 进行熔断
	@GetMapping("/buy/feign/hystrix/{id:\\d+}")
	public TbProduct feignhystrix(@PathVariable Long id) {
		return productFeign.waitfindById(id);
	}

	// hystrix 熔断器 进行测试  //1.配置文件将阈值进行调整 （心跳时间，触发熔断的请求数，失败占比），模拟 当1 正常 2抛出错误
	@GetMapping("/buy/curcuit/{id:\\d+}")
	@HystrixCommand(fallbackMethod = "curcuitBreakerfall")
	public TbProduct curcuitBreaker(@PathVariable Long id) {
		if(id!=1) {
			throw new RuntimeException("模拟服务异常 触发熔断");
		}
		String serviceName = "misco-product";
		return restTemplate.getForObject("http://" + serviceName + "/product/1", TbProduct.class);
	}
	
	public TbProduct curcuitBreakerfall(@PathVariable Long id){
		return new TbProduct("熔断了嘿嘿");
	}
	
	

}
