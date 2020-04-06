package com.my.misco.importBeanDifinationRegistrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.my.misco.importannotation.RainBow;

/**
 * 手动注入bean导入ioc
 * @author liuwei
 */
public class MyDefinitionRegistra implements ImportBeanDefinitionRegistrar{
	/**
	 * importingClassMetadata 当前improt 进来的的类的注解信息
	 * registry，这个将我们的bean注入到我们的容器中
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		
		//如果有Color这个组件 我们再去将RainBow 注册进来
		if(registry.containsBeanDefinition("com.my.misco.importannotation.Color")) {
			//将BeanDefinition接口的实现类RootBeanDefintion,还可以设置他的作用域
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			//将彩虹这个class注入到我们的bean中
			registry.registerBeanDefinition("rainBow", rootBeanDefinition);	
		}
	}
}
