package com.my.misco.aop.v2;

import org.springframework.stereotype.Component;

@Component
public class Hello {
	/**
	 * hello()方法调用了同类中的另一个方法hello(String)，
	 * 此时hello(String)上的切面逻辑就无法执行了。
	 * 这里，我们要对hello()方法进行改造，强制它调用代理对象中的hello(String)。改造结果如下：
	 **/
	public void hello() {
		System.out.println("hello");
		this.hello("ss");
	}

	public void hello(String a) {
		System.out.println("hello fdf");
	}


}
