/**
 * 
 */
package com.misco.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.misco.server.dto.TbProduct;

/**
 * @author liuwei
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	// 通过地址 但是不好维护 地址是可变化的
	@Autowired
	private RestTemplate restTemplate;
	// 进行ribbon进行调度 拉取consul 服务 进行负载
	@GetMapping("/buy/ribbon/consul/{id:\\d+}")
	public TbProduct getribbon(@PathVariable Long id) {
		String serviceName = "misco-consul-product";
		return restTemplate.getForObject("http://" + serviceName + "/product/1", TbProduct.class);
	}
}
