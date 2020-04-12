/**
 * 
 */
package com.misco.server.ioc.xml.facotory;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuwei 静态或者简单工厂方法
 */
public abstract class BeanFactory {
	public static Animous getAnimous(String key) {
		if (StringUtils.equals(key, "dog")) {
			return new Dog();
		} else if (StringUtils.equals(key, "cat")) {
			return new Cat();
		}else if (StringUtils.equals(key, "pig")) {
			return new Pig();
		}
		return null;
	}
}
