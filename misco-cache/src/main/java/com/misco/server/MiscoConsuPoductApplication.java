/**
 * 
 */
package com.misco.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author liuwei
 * 使用注解版的mybatis 
 */
@SpringBootApplication
@MapperScan(basePackages="com.misco.server.mapper") //指定扫描mapper
//开启缓存
@EnableCaching
public class MiscoConsuPoductApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoConsuPoductApplication.class, args);
	}
}
