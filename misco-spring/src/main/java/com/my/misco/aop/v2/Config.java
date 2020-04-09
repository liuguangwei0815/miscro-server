package com.my.misco.aop.v2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.my.misco.aop.v2")
@EnableAspectJAutoProxy
public class Config {
}
