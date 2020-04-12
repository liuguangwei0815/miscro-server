package com.misco.server.condi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

/**
 * 
 * @author liuwei
 * 1、注解格式 ： 返回 key default 返回的默认值
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(MyContitionOnProperties.class)
public @interface AnnotationOnProperties {
	String[] value() default {};
	String desc() default "Hei man";
}
