/**
 * 
 */
package com.misco.server;

import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import com.misco.server.initzer.MyInitiazer2;
import com.misco.server.listener.SecondeListener;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
public class MiscoOrderApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		//第一种启动方式：
//		//ConfigurableApplicationContext run = SpringApplication.run(MiscoOrderApplication.class, args);
//		//第二种启动方式：
//		SpringApplication springApplication = new SpringApplication(MiscoOrderApplication.class);
//		springApplication.addInitializers(new MyInitiazer2());
//		//添加我们的监听器
//		springApplication.addListeners(new SecondeListener());
//		springApplication.run(args);
//		//第三种是值直接放到配置文件 然后获取
		
		System.out.println("\u001B[32m :: Spring boot :: ]");
		
		//设置兜底的Banner
		SpringApplication springApplication = new SpringApplication(MiscoOrderApplication.class);
		springApplication.setBanner(new ResourceBanner(new ClassPathResource("banner_bak.txt")));
		springApplication.run(args);
		
	}
}
