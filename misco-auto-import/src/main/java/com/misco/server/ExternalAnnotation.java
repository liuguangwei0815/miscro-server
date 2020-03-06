/**
 * 
 */
package com.misco.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @author liuwei
 * 外部配置类加载注解
 */
@Retention(RetentionPolicy.RUNTIME) //什么运行
@Documented
@Target(ElementType.TYPE)//租用在方法上
@Import(ExternalConfigImport.class) // 自动加入
public @interface ExternalAnnotation {

}
