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
public class BeanConfig3 {
	//利用FactoryBean进行注入，默认注入的是你调用getObject方法返回的实例
	//1、获取getObject方法里范湖的对象（默认）
	//2、如果想获取本身需要配置&
	@Bean
	public MyFactoryBean myFactoryBean() {
		return new MyFactoryBean();
	}
}
