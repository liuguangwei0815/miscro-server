package com.my.misco.aop.v1;

import java.util.Arrays;

import org.aspectj.bridge.MessageUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * aop 类
 * 
 * @author liuwei 1、JoinPoint joinPoint 这个一定要放在参数的第一个位置，否者会抛出异常 2。throwing=“”
 *         和参数要一样 接受异常
 */
@Aspect // 标志位切面类
@Component
public class AopClass {
	// 抽取公共,不用每个方法写 *:代表所有方法，。。：所有参数
	@Pointcut("execution(public int com.my.misco.aop.v1.Caculator.*(..))")
	public void pointcout() {
	}

	// 之前
	@Before(value = "pointcout()")
	public void before(JoinPoint joinPoint) {
		// 参数
		Object[] args = joinPoint.getArgs();
		// 方法名称
		String name = joinPoint.getSignature().getName();
		String msg = String.format("before参数名称：%s参数列表:%s", name, Arrays.asList(args));
		System.out.println(msg);
	}

	// 结束 无论方法异常非异常
	@After("pointcout()")
	public void after(JoinPoint joinPoint) {
		// 参数
		Object[] args = joinPoint.getArgs();
		// 方法名称
		String name = joinPoint.getSignature().getName();
		String msg = String.format("after参数名称：%s参数列表:%s", name, Arrays.asList(args));
		System.out.println(msg);
	}

	// 后置通知 正常返回 ，下面这个表达式，可以由外部类应用
	@AfterReturning(value = "com.my.misco.aop.v1.AopClass.pointcout()",returning = "result")
	public void afterreturning(JoinPoint joinPoint,Object result) {
		// 参数
		Object[] args = joinPoint.getArgs();
		// 方法名称
		String name = joinPoint.getSignature().getName();
		String msg = String.format("afterreturning参数名称：%s参数列表:%s,返回结果是：%s", name, Arrays.asList(args),result);
		System.out.println(msg);
	}

	// 错误抛出
	@AfterThrowing(value = "pointcout()", throwing = "exception")
	public void afterthrowing(JoinPoint joinPoint, Exception exception) {
		// 参数
		Object[] args = joinPoint.getArgs();
		// 方法名称
		String name = joinPoint.getSignature().getName();
		String msg = String.format("错误抛出参数名称：%s参数列表:%s,参数异常：%s", name, Arrays.asList(args),exception);
		System.out.println(msg);
		;
	}
}
