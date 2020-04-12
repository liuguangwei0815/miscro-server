package com.misco.server.event;

public class Test {

	public static void main(String[] args) {
		// 定义天气广播器
		WeathMulticaster multicaster = new WeathMulticaster();
		// 定义两个监听器
		SnowListener snowListener = new SnowListener();
		RainListener rainListener = new RainListener();
		//添加到我们的广播器中
		multicaster.addListener(snowListener);
		multicaster.addListener(rainListener);
		//发布两个事件
		multicaster.multicasterEvent(new SnowEvent());
		multicaster.multicasterEvent(new RainEvent());
		//移除下雨事件
		multicaster.removeListener(rainListener);
		//再添加两个事件，其中下雨事件没有监听器了，所以无法监听
		multicaster.multicasterEvent(new SnowEvent());
		multicaster.multicasterEvent(new RainEvent());
	}
}
