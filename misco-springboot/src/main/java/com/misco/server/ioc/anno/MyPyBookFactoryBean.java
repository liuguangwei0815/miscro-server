package com.misco.server.ioc.anno;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liuwei
 *
 */
@Component
public class MyPyBookFactoryBean implements FactoryBean<Book>{
	//返回的是这个对象，如果想获取本身这个容器 需要用到&
	@Override
	public PyBook getObject() throws Exception {
		return new PyBook();
	}
	//返回的这个bean类型
	@Override
	public Class<?> getObjectType() {
		return Book.class;
	}
}
