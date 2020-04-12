/**
 * 
 */
package com.misco.server.event;

import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 下雪的监听器
 */
@Component
public class SnowListener implements WeathListener {
	@Override
	public void onWeathEvent(AbstractWeathEvent event) {
		//如果下雪天气打印天气的名称，否者不做任何操作，制作当前处理
		if(event instanceof SnowEvent) {
			System.out.println("hello "+event.getWeather());
		}
	}
}
