/**
 * 
 */
package com.misco.server.listenner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author liuwei stream 消息发送
 */
@Component
//@EnableBinding(Source.class)//这个内部类的bean的名称叫做output 对应的就是MessageChannel 的bean的名称
@EnableBinding(MyChannel.class) // 因为需要messageChannel 对象所以要将sourc binding进来
public class MyMessageSender {

	@Autowired
	private MessageChannel myoutput; // 这个名词必须叫做output 因为他和配置文件的out 和 Source 绑定否者或抛出找不到

	public void Send(Object obj) {
		myoutput.send(MessageBuilder.withPayload(obj).build());
	}

}
