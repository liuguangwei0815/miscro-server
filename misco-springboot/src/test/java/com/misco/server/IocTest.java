package com.misco.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.misco.server.event.WeathRunLitener;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = MiscoOrderApplication.class)
public class IocTest {

	@Autowired
	private WeathRunLitener weathRunLitener;
	
	//测试springboot监听器解析
	@Test
	public void testMulticaster() {
		weathRunLitener.snow();
		weathRunLitener.rain();
	}

}
