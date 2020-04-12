package com.misco.server.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

public class FourListener implements SmartApplicationListener {

	// 你在该时间处理的逻辑
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("SmartApplicationListener do somthing 我的第四个监听器");
	}

	// 支持什么事件 你感兴趣的时间
	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		/**
		 * Assignable *确定类或接口是否由它表示 {@code Class}对象或者与超类相同，或者是超类 的超接口，由指定的类或接口表示
		 * {@code Class}参数。如果是，则返回{@code true}; 否则返回{@code false}。如果这个{@code类}
		 * 
		 * 这里的逻辑判断该eventType是否是started时间， 和实例化prepare事件，但是ext扩展还未实现
		 *
		 ***/
		if (eventType.isAssignableFrom(ApplicationStartedEvent.class)
				|| eventType.isAssignableFrom(ApplicationPreparedEvent.class)) {
			//返回true 就是标识该监听器 兴趣这些事件
			return true;
		}
		return false;
	}

}
