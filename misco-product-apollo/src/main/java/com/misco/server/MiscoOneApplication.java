/**
 * 
 */
package com.misco.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * @author liuwei
 *
 */
@SpringBootApplication
@EnableApolloConfig //启动apollo 
public class MiscoOneApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MiscoOneApplication.class, args);
	}

}
