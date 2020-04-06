package com.my.misco.conditional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * linu的conditon
 * @author liuwei
 */
public class LinuxContion implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//ConditionContext 条件判断上下文呢
		//获取我们的bean工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取环境变量
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println("系统名称"+property);
		
		//可以设定beande名称和beandefinition ，移除bean，beandefinition的数量，是否已经用到了这个bean的名称，和某个bean的名称
		BeanDefinitionRegistry registry = context.getRegistry();
		
		BeanDefinition beanDefinition = registry.getBeanDefinition("person");
		System.out.println("person的definition:"+beanDefinition);
		
		
		if(property.contains("linux")) {
			return true;
		}
		//如果需要注册到ioc返回true，否者false
		return false;
	}
}
