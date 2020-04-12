package com.misco.server.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * 我的第一个监听器
 * @author liuwei
 * 泛型里面是你感兴趣的事件
 */
@Order(1)
public class FirstListener implements ApplicationListener<ApplicationStartedEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("我的第一个监听器");
	}
}
