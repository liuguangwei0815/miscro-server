package com.misco.server.controlloer;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController implements ApplicationContextAware {
	private ApplicationContext applicationContext; 
	@RequestMapping
	@RespectBinding
	public Object test() {
		//是获取Map上的
		String property = applicationContext.getEnvironment().getProperty("key1");
		System.out.println("thirdEnv3:"+property);
		//获取端口号
		String port = applicationContext.getEnvironment().getProperty("local.server.port");
		System.out.println("prot:"+port);
		//第二种
		String property2 = applicationContext.getEnvironment().getProperty("key2");
		//第三种
		String property3 = applicationContext.getEnvironment().getProperty("key3");
		return property3;
		
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
