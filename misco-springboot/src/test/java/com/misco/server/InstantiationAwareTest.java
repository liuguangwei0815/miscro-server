package com.misco.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.misco.server.work.Work;

/**
 * InstantiationAwareBeanPostProcessor
 * @author liuwei
 *
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = MiscoOrderApplication.class)
public class InstantiationAwareTest {
	
	@Autowired
	Work work;
	
	@Test
	public void test() {
		System.out.println("==="+work.getName());
	}
	
	

}
