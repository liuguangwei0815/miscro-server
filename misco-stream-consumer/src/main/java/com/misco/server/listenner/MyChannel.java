/**
 * 
 */
package com.misco.server.listenner;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author liuwei 自定义输出输入通道
 */
public interface MyChannel {

	// 自定义生产通道
	String MYOUTPUT = "myoutput";

	@Output(MyChannel.MYOUTPUT)
	MessageChannel myoutput();

	// 自定义消费通道
	String MYINPUT = "myinput";

	@Input(MyChannel.MYINPUT)
	MessageChannel myinput();

}
