/**
 * 
 */
package com.my.misco.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 *
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent>{

	//发布监听了能监听到时间 事件只能是ApplicationEvent旗下的
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("我收到了事件："+event.getSource().toString());
	}
}
