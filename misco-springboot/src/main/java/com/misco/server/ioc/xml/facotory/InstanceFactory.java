package com.misco.server.ioc.xml.facotory;

import org.apache.commons.lang3.StringUtils;

public class InstanceFactory {
	public Animous getAnimous(String key) {
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
