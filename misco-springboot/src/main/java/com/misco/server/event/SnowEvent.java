/**
 * 
 */
package com.misco.server.event;

import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * 下雪天气
 */
public class SnowEvent extends AbstractWeathEvent{
	@Override
	public String getWeather() {
		return "下雪天气";
	}
}
