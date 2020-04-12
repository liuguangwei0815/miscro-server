package com.misco.server.stopwatch;

import org.springframework.util.StopWatch;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		//使用springBoot的计时器
		StopWatch watch = new StopWatch("myfirstWatch");
		watch.start("one");
		Thread.sleep(1000);
		watch.stop();
		
		watch.start("two");
		Thread.sleep(2000);
		watch.stop();
		
		watch.start("three");
		Thread.sleep(3000);
		watch.stop();
		
		System.out.println(watch.prettyPrint());
	}

}
