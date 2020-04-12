/**
 * 
 */
package com.misco.server.event;

import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 下雨的监听器
 */
@Component
public class RainListener implements WeathListener {
	//如果下雨才打印
	@Override
	public void onWeathEvent(AbstractWeathEvent event) {
		if (event instanceof RainEvent) {
			System.out.println("hello "+event.getWeather());
		}
	}
}
