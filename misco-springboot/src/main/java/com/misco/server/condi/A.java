package com.misco.server.condi;

import org.springframework.stereotype.Component;

@Component
//配置文件必须存在onp
//@ConditionalOnProperty("onp")
@AnnotationOnProperties(value = {"annov1","annov2"},desc = "Hei ggg")
public class A {
}
