package com.misco.server.listenner;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class) // 开启绑定 同时通过source 注入 messageChannel对象  内置消费通道
public class MessageListener {
	
	
	@StreamListener(Sink.INPUT)
	public void messageLister(String message) {
		System.out.println("我接收到了信息是："+message);
	}

}
