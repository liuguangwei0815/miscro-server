package com.misco.server.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * 通过yml 或者 properties 配置 context.listener.classes =  这个优先与其他的 DelegatingApplicatinListener 硬编码
 * @author liuwei
 */
@Order(3)
public class T3Listener implements ApplicationListener<ApplicationStartedEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("我的第3个监听器");
	}
}
