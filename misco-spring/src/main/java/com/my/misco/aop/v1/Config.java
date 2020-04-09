package com.my.misco.aop.v1;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.aop.framework.AopInfrastructureBean;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.aop.framework.ProxyProcessorSupport;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;

@Configuration
@ComponentScan(value = "com.my.misco.aop.v1")
@EnableAspectJAutoProxy//启动基于注解的aop模式
/**
 * AOP 源码解析（注册了什么，什么时候注册，注册的工作内容）
 *  @EnableAspectJAutoProxy
 *  	@Import(AspectJAutoProxyRegistrar.class)
 *  		AspectJAutoProxyRegistrar
 *  			implements ImportBeanDefinitionRegistrar（可以看到他是利用 ImportBeanDefinitionRegistrar  来注入组件的 ，现在我们看下他是怎么注入的呢）
 *  				AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry); 将AnnotationAwareAspectJAutoProxyCreator 注册到我们的容器中 ，同时看这个@EnableAspectJAutoProxy 暴露prox呀 等
 *  					注册这个对象：bean的名称：internalAutoProxyCreator，class：AnnotationAwareAspectJAutoProxyCreator（理解这个对象就可以理解aop原理的）
 *  				重要组件：AnnotationAwareAspectJAutoProxyCreator
 *  						- extends AspectJAwareAdvisorAutoProxyCreator
 *  							- extends AbstractAdvisorAutoProxyCreator
 *  								- extends AbstractAutoProxyCreator
 *  										#上面这个1 2 （关注后置处理器， bean初始化前后做的事情，自动装配BeanFactoryAware）
 *  										 - 1、extends ProxyProcessorSupport
 *  												ProxyConfig implements Ordered, BeanClassLoaderAware, AopInfrastructureBean
 *  										 - 2、implements SmartInstantiationAwareBeanPostProcessor, 
 *  															- extends InstantiationAwareBeanPostProcessor extends BeanPostProcessor
 *  											             BeanFactoryAware 
 *  															- extends Aware
 * 可以看到他也是通弄过我们的BeanPostProcessor 后置处理进行处理的
 * 				流程：
 * 					1、传入配置类 ，创建ioc容器
 * 					2、注册配置类，调用refrush方法 刷新容器
 * 					3、registerBeanPostProcessor(BeanFactory),注册bean的后置处理器方便拦截bean的创建
 * 						1、先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 * 						2、给容器加载别的BeanPostProcessor
 * 						3、优先注册实现了priorityOrdered接口的BeanPostProcessor
 * 						4、 再给容器注册了s
 * 						5、注册没有实现优先级的接口beanPostProcessor
 * 
 *  
 * 
 * 
 * @author liuwei
 *
 */
public class Config {
}
