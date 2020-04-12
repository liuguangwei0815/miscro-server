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
@Order(1)
public class FirstCommandlineRunner2 implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("启动加载器开始执行任务2");
	}
}
