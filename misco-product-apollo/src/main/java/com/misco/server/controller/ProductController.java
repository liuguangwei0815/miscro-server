/**
 * 
 */
package com.misco.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misco.server.entity.TbProduct;
import com.misco.server.service.TbProductService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuwei
 *
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
	@Autowired
	private TbProductService tbProductService;
	
	@Value("${spring.cloud.client.ip-address:UNKONW}")
	private String ip;
	@Value("${server.port:UNKONW}")
	private String port;
	
	//自定义值 测试配置中心的值
	@Value("${testname1:UNKONW}")
	private String testConfigValue;
	
	@GetMapping
	public List<TbProduct> findAll() {
		return tbProductService.findAll();
	}
	
	//测试配置中心的值是否动态改变
	@GetMapping("/test")
	public String configtest() {
		return testConfigValue;
	}
	
	
	/**
	 * 模拟短暂不可用 重试机制
	 * @param id
	 * @return
	 */
	@GetMapping("/retry/{id}")
	public TbProduct waitfindById(@PathVariable Long id) {
		
		//测试超时返回 如果是7050 通过id进行
		if(port.equals("7050")) {
			log.info("端口："+port+"开始休眠:"+id);
			try {
				Thread.sleep(id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		TbProduct tb = tbProductService.findById(1l);
		tb.setProductName("调用的IP:"+ip+"端口号为:"+port);
		return tb;
	}
	
	@GetMapping("/{id:\\d+}")
	public TbProduct findById(@PathVariable Long id) {
		TbProduct tb = tbProductService.findById(id);
		tb.setProductName("调用的IP:"+ip+"端口号为:"+port);
		return tb;
	}
	
	@PostMapping
	public String save(@RequestBody TbProduct product) {
		tbProductService.save(product);
		return "保存成功";
	}
	@PutMapping("/{id}")
	public String update(@RequestBody TbProduct product) {
		tbProductService.update(product);
		return "修改成功";
	}
	@DeleteMapping("/{id}")
	public String delete(Long id) {
		tbProductService.delete(id);
		return "删除成功";
	}
	
	@GetMapping("/wait/{id:\\d+}")
	public TbProduct findByIdwait(@PathVariable Long id) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TbProduct tb = tbProductService.findById(id);
		tb.setProductName("调用的IP:"+ip+"端口号为:"+port);
		return tb;
	}
	
}
