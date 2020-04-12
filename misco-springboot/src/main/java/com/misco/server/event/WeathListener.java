/**
 * 
 */
package com.misco.server.event;

/**
 * @author liuwei 天气监听器
 */
public interface WeathListener {
	//对应的天气做相应的时间 ，抽象类无法当做参数 除非在接口或者抽象类上
	void onWeathEvent(AbstractWeathEvent event);
}
