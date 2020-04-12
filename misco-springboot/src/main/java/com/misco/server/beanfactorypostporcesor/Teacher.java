/**
 * 
 */
package com.misco.server.beanfactorypostporcesor;

import org.springframework.stereotype.Component;

/**
 * @author liuwei
 *
 */
@Component
public class Teacher {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
