package com.my.misco.aop.v2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HellowAspect {

	@Pointcut("execution(public void com.my.misco.aop.v2.Hello.hello())")
	public void pc() {
	}

	@Before("pc()")
	public void bf() {
		System.out.println("before");
	}

}
