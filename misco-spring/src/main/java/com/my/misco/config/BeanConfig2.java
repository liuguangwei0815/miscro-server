/**
 * 
 */
package com.my.misco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.my.misco.Person;
import com.my.misco.conditional.LinuxContion;
import com.my.misco.conditional.WindowsContion;
import com.my.misco.factorybean.MyFactoryBean;
import com.my.misco.importBeanDifinationRegistrar.MyDefinitionRegistra;
import com.my.misco.importannotation.Color;
import com.my.misco.importannotation.Red;
import com.my.misco.importselector.MyInportSelector;

/**
 * @author liuwei
 *
 */
@Configuration
@Conditional({WindowsContion.class})//在windows添加bean，遇到下面的linux 那么是不会加载进来的
//引进了class，importSelector（批量导入），importBeanDefinitonRegistar（手动导入，可以指定bean的名称）
@Import({Color.class,Red.class,MyInportSelector.class,MyDefinitionRegistra.class})//使用@import导入组件，默认是全列名
public class BeanConfig2 {
	@Lazy // 针对单例的，加上这个注解 他就不会在ioc启动时候建立，在调用时候建立单例对象
	@Bean // 方法名默认作为id
	public Person person() {
		System.out.println("创建person");
		return new Person("configBean jack ", 3);
	}
	//需求 当winods加载此bean
	@Bean("bill")
	public Person person1() {
		return new Person("bill gusy ", 60);
	}
	//需求 当linux加载此bean
	@Bean("linux")
	@Conditional({LinuxContion.class})//在linux添加bean
	public Person person2() {
		return new Person("linux ", 56);
	}
	//利用FactoryBean进行注入，默认注入的是你调用getObject方法返回的实例
	//1、获取getObject方法里范湖的对象（默认）
	//2、如果想获取本身需要配置&
	@Bean
	public MyFactoryBean myFactoryBean() {
		return new MyFactoryBean();
	}
}
