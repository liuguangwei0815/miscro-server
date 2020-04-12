package com.misco.server.ioc.anno;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public void hello() {
		System.out.println("hello");
	}
}
