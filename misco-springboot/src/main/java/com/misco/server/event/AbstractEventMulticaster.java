/**
 * 
 */
package com.misco.server.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuwei 抽象事件广播器
 */
@Component
public abstract class AbstractEventMulticaster implements EventMulticaster {

	// 监听器的集合
	@Autowired
	private List<WeathListener> listenerList;

	@Override
	public void multicasterEvent(AbstractWeathEvent event) {
		// 定义模板方法,让我们的具体实现类去做
		doStart();
		// 可选方法，让具体实现类去决定是否要执行
		if (isPase()) {
			doOther();
		}
		//发布事件
		listenerList.forEach(e->e.onWeathEvent(event));
		
		doEnd();
	}

	// 是否终止
	protected boolean isPase() {
		return false;
	}

	// 做其他事情 这个可选
	protected final void doOther() {
		System.out.println("我再去做些其他事情");
	}

	//子类实现
	protected abstract void doEnd();
	//子类实现
	protected abstract void doStart();

	@Override
	public void addListener(WeathListener listener) {
		listenerList.add(listener);
	}

	@Override
	public void removeListener(WeathListener listener) {
		listenerList.remove(listener);
	}

}
