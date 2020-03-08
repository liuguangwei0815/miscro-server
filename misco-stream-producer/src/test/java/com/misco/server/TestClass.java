package com.misco.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.misco.server.message.MessageSender;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestClass {
	
	@Autowired
	private MessageSender messageSender;
	
	@Test
	public void test1() {
		messageSender.Send("我又来了");
	}

}
