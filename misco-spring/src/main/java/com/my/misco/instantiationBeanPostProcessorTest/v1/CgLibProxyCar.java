package com.my.misco.instantiationBeanPostProcessorTest.v1;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CgLibProxyCar implements MethodInterceptor {

	private Object targer;

	public Object getInstance(Object targer) {
		this.targer = targer;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targer.getClass().getSuperclass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("代理前方法");
		Object obj = arg1.invoke(targer, arg2);
		System.out.println("代理后方法");
		return obj;
	}

}
