package com.misco.server.work;

import org.springframework.stereotype.Component;

/**
 * 定义这个作用源码跟踪
 * 
 * @author liuwei
 *
 */
@Component
public class Work {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
