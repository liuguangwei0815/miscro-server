/**
 * 
 */
package com.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystarter.config.HelloServer;

/**
 * @author liuwei
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private HelloServer helloServer;
	
	@GetMapping
	public String test() {
		return helloServer.sayHello("ÐÇ122");
	}

}
