package com.misco.server.event;

import org.springframework.stereotype.Component;

/**
 * 天气广播器
 * 
 * @author liuwei
 *
 */
@Component
public class WeathMulticaster extends AbstractEventMulticaster {
	@Override
	protected void doStart() {
		System.out.println("广播开始");
	}
	@Override
	protected void doEnd() {
		System.out.println("广播结束");
	}
}
