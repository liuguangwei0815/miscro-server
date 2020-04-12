/**
 * 
 */
package com.misco.server.bootrunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 启动加载器
 */
@Component
@Order(0)
public class FirstCommandlineRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("启动加载器开始执行任务1");
	}
}
