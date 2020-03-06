/**
 * 
 */
package com.misco.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.misco.server.dto.TbProduct;
import com.misco.server.feign.ProductFeign;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuwei
 *
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	// 通过
	@Autowired
	private DiscoveryClient discoveryClient;

	// 通过地址 但是不好维护 地址是可变化的
	@Autowired
	private RestTemplate restTemplate;

	// 通过feign 进行服务调用
	@Autowired
	private ProductFeign productFeign;

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

}
