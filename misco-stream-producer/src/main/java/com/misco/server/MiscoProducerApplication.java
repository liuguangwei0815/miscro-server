/**
 * 
 */
package com.misco.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuwei
 *  平常开发中有可能需要实现在项目启动后执行的功能  使用CommandLineRunner
 *  1/依赖
 *  2、配置yml rabbit 和 stream 
 *  3/注入管道
 */
@SpringBootApplication
public class MiscoProducerApplication  {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoProducerApplication.class, args);
	}
}
