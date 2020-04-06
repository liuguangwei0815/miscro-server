/**
 * 
 */
package com.my.misco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.my.misco.Person;
import com.my.misco.PersonDao;

/**
 * @author liuwei
 *
 */
@Configuration //告诉spring 容器这个是配置类 ,这里是将有个标有注解的地方不融进我们的spring ioc 容器
@ComponentScan(value = "com.my.misco.config",
//excludeFilters= {@Filter(type = FilterType.ANNOTATION,classes = Controller.class)})//他会扫描我们下面的所有注释为@controlller @server 等诸如到sprng 容器红
//只包含
includeFilters = {
//		@Filter(type = FilterType.ANNOTATION,classes = Controller.class),
//		//将PersonDao这种类型也放进来
//		@Filter(type = FilterType.ASSIGNABLE_TYPE,classes =PersonDao.class )
		@Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
},useDefaultFilters = false
)
public class BeanConfig {
	@Bean //方法名默认作为id
	public Person person() {
		return new Person("configBean jack ",3);
	}
}
