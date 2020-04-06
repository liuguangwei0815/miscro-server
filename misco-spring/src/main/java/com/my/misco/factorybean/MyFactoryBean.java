package com.my.misco.factorybean;

import org.springframework.beans.factory.FactoryBean;

import com.my.misco.importannotation.Color;

/**
 * T 就是你返回的类型，FacotryBean 或者我们的spirng中的BeanFacotry 一样是这样子
 * @author liuwei
 */
public class MyFactoryBean implements FactoryBean<Color> {
	//如果这个MyFactoryBean 注入到容器，默认得到的是这个getObject方法返回的对象，如果想获取工厂本身需要&符号进行标识
	@Override
	public Color getObject() throws Exception {
		return new Color();
	}
	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}
	//是否单例，这个通过true（是单例），false（多例），默认为true，也是 如果单例是立即初始化，多利是懒加载的方式
	@Override
	public boolean isSingleton() {
		return FactoryBean.super.isSingleton();
	}
}
