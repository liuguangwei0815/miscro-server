package com.misco.server.condi;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyContitionOnProperties implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		//获取Annotation对象
		Map<String, Object> annotationAttributes = metadata
				.getAnnotationAttributes("com.misco.server.condi.AnnotationOnProperties");
		//获取对象的key 这个key就是我们的在注解类定义的属性值
		String[] object = (String[]) annotationAttributes.get("value");
		String desc = (String) annotationAttributes.get("desc");
		for (String string : object) {
			String property = environment.getProperty(string);
			//属性配置文件不能为空而且Desc 这个属性值一定要包含Hei 否则不进行注册
			if (StringUtils.isEmpty(property)||!StringUtils.contains(desc,"Hei" )) {
				return false;
			}
		}
		return true;
	}
}
