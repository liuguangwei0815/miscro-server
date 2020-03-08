package com.misco.server.listenner;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.misco.server.message.MyChannel;

/**
 * 生产者自己监听自己发送的消息
 * 
 * @author liuwei
 *
 */
//@Component
//@EnableBinding(MyChannel.class)
public class MyListenner {
	
	@StreamListener(MyChannel.MYINPUT)
	public void listennermysle(String msg) {
		System.out.println("我监听到自己了："+msg);
	}
}
