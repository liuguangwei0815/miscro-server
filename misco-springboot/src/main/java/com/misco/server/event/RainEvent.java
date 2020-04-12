/**
 * 
 */
package com.misco.server.event;

import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 下雨事件
 */
public class RainEvent extends AbstractWeathEvent{
	@Override
	public String getWeather() {
		// TODO Auto-generated method stub
		return "下雨天气";
	}
}
