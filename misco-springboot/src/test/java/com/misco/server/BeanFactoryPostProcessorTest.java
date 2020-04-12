package com.misco.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.misco.server.beanfactorypostporcesor.Teacher;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = MiscoOrderApplication.class)
public class BeanFactoryPostProcessorTest {
	@Autowired
	Teacher teacher;
	
	//测试BeanFactory 是否实例化前注入到我们的属性中
	@Test
	public void test() {
		System.out.println(teacher.getName());
	}
}
