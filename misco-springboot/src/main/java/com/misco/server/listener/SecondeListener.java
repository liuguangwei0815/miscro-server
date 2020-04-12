package com.misco.server.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
/**
 * ApplicationStartedEvent spring bean 已经instance 完成了
 */
@Order(2)
public class SecondeListener implements ApplicationListener<ApplicationStartedEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("我的第二个监听器");
	}
}
