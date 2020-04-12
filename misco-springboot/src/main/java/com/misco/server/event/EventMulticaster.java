package com.misco.server.event;

/**
 * 事件广播器
 * @author liuwei
 */
public interface EventMulticaster {
	/**广播事件**/
	void multicasterEvent(AbstractWeathEvent event);
	/**新增监听器**/
	void addListener(WeathListener listener);
	/**删除监听器**/
	void removeListener(WeathListener listener);
}
