package com.misco.server.listenner;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 生产者自己监听自己发送的消息
 * 
 * @author liuwei
 *
 */
@Component
@EnableBinding(MyChannel.class)
public class MyListenner {
	
	@StreamListener(MyChannel.MYINPUT)
	public void listennermysle(String msg) {
		System.out.println("消费端接收到了自定信息："+msg);
	}
	

}
