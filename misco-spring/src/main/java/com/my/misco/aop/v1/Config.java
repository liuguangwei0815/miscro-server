package com.my.misco.aop.v1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.my.misco.aop.v1")
@EnableAspectJAutoProxy//启动基于注解的aop模式
public class Config {
}
