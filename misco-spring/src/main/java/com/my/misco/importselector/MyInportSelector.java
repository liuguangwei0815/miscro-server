/**
 * 
 */
package com.my.misco.importselector;

import java.util.Set;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.my.misco.conditional.WindowsContion;

/**
 * @author liuwei
 * 1、批量导入组件
 * 2、方法不能反返回null
 */
public class MyInportSelector implements ImportSelector{
	/**
	 * 1、不能返回null 否者报错
	 * 2、AnnotationMetadata:
	 * 	可以获取当前@import 注解类的所有注解信息，比如这导入这个类的BeanConfig2 他有@Configuration、@Conditional({WindowsContion.class})
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//获取当前引用该selector 的 @improt类的所有注解信息
		Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
		for (String string : annotationTypes) {
			System.out.println("当前@improt类的注解信息："+string);
		}
		//返回数组，元素是全类名字
		return new String[] {"com.my.misco.importannotation.Bulur","com.my.misco.importannotation.Yellow"};
	}
}
