/**
 * 
 */
package com.my.misco.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @author liuwei
 *
 */
public class MyTypeFilter implements TypeFilter {
	/**
	 * metadataReader : 当前读取的类信息 ，子类member，父类，接口，calzz对象,注解信息 metadataReaderFactory：
	 * 获取其他类信息
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// 获取当前类的注解类信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取当前类信息 当前读取的类信息 ，子类member，父类，接口，calzz对象,注解信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		// 获取当前扫描类的包路径呀等
		Resource resource = metadataReader.getResource();
		System.out.println("获取当前类名-》"+classMetadata.getClassName()+"===>当前路径："+resource.getURI()+",===>url:"+resource.getURL());
		// 匹配返回true，否者返回false
		if(classMetadata.getClassName().contains("st")) {
			return true;
		}
		return false;
	}
}
