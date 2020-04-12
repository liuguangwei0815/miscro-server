/**
 * 
 */
package com.misco.server.ioc.anno;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liuwei
 * 通过 ImportBeanDefinitionRegistrar
 */
public class MathBookImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		RootBeanDefinition beanDefinition = new RootBeanDefinition(MathBook.class);
		registry.registerBeanDefinition("mathBook", beanDefinition);
	}
}
