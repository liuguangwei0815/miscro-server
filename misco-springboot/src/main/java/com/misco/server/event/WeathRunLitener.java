/**
 * 
 */
package com.misco.server.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 模拟springboot 容器启动接口
 */
@Component
public class WeathRunLitener {
	//将广播器注入进来
	@Autowired
	private EventMulticaster eventMulticaster;
	//下雪接口
	public void snow() {
		//帆布下雪事件
		eventMulticaster.multicasterEvent(new SnowEvent());
	}
	//下雨事件接口
	public void rain() {
		//帆布下雪事件
		eventMulticaster.multicasterEvent(new RainEvent());
	}
}
