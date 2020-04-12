package com.misco.server.ioc.xml;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * @author liuwei
 *
 */
@Data
public class Student {
	private String name;
	private Integer age;
	private List<String> classlist;
	
	//通过有参数构造器进行注入
	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", classlist=" + StringUtils.join(classlist, ",") + "]";
	}
	
}
