package com.misco.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.misco.server.ioc.anno.Book;
import com.misco.server.ioc.anno.HelloService;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = MiscoOrderApplication.class)
public class BeanAnnoTest {
	
	@Autowired
	private HelloService helloService;
	@Test
	public void test() throws Exception {
		helloService.hello();
	}
	//通过FactoryBean注册组件
	@Autowired
	@Qualifier("myPyBookFactoryBean")
	private Book book;
	@Test
	public void testFactoryBean() {
		System.out.println(book.getBookName());
	}
	
	//通过BeanDefinitionRegistryPostProcessor
	@Autowired
	private Book sufaBook;
	@Test
	public void testBeanDefinitionRegistryPostProcessorBean() {
		System.out.println(sufaBook.getBookName());
	}
	
	//通过importBeanDefinitionRegistrar注册bean 和 BeanDefinitionRegistryPostProcessor 这个后置处理器
	@Autowired
	private Book mathBook;
	@Test
	public void testimportBeanDefinitionRegistrar() {
		System.out.println(mathBook.getBookName());
	}
	
	
	
	
	
	
	
	
}
