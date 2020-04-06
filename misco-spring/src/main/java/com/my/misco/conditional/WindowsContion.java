package com.my.misco.conditional;

import java.net.URL;

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
public class WindowsContion implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//ConditionContext 条件判断上下文呢
		//获取我们的bean工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//类加载器
		ClassLoader classLoader = context.getClassLoader();
		URL url = classLoader.getResource("bill");
		System.out.println("URL"+url);
		//获取环境变量
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println("系统名称"+property);
		
		//可以设定beande名称和beandefinition ，移除bean，beandefinition的数量，是否已经用到了这个bean的名称，和某个bean的名称
		BeanDefinitionRegistry registry = context.getRegistry();
		//这里获取不了的 因为 bena还未有实例化 ，获取会抛出异常
//		BeanDefinition beanDefinition = registry.getBeanDefinition("bill");
//		System.out.println("bill de beanDefinition:"+beanDefinition);
		if(property.contains("Windows")) {
			return true;
		}
		//如果需要注册到ioc返回true，否者false
		return false;
	}

}
