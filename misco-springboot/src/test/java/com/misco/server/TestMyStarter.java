package com.misco.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = MiscoOrderApplication.class)
public class TestMyStarter {
	@Autowired
	private WeatherServivce weatherServivce;
	
	@Test
	public void test() {
		System.out.println(weatherServivce.getType()+"-"+weatherServivce.getRate());
	}
}
