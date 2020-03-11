package com.misco.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MiscoOneApplication.class)
public class TestClass {

	//只能读取默认的application 名字空间
	@Test
	public void test1() {
		Config config = ConfigService.getAppConfig();
		String ss = config.getProperty("testname1", null);
		System.out.println(ss);
		
	}
	
	//读取自定义空间
	@Test
	public void test2() throws InterruptedException {
		
		while(true) {
			Thread.sleep(1000);
			Config config = ConfigService.getConfig("rokectmq-config");
			String ss = config.getProperty("rocketmq.address", null);
			System.out.println(ss);
		}
		
	}
	
	//获取公共属性
		@Test
		public void test3() throws InterruptedException {
			
			while(true) {
				Thread.sleep(1000);
				Config config = ConfigService.getConfig("microserver.comm-config");
				String ss = config.getProperty("myname", null);
				System.out.println("获取的"+ss);
			}
			
		}
	

}
