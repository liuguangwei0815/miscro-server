package com.misco.server;

import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.misco.server.event.WeathRunLitener;
import com.misco.server.ioc.xml.Student;
import com.misco.server.ioc.xml.facotory.Animous;
import com.misco.server.ioc.xml.facotory.Pig;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = MiscoOrderApplication.class)
@ContextConfiguration(locations = { "classpath:ioc/demo.xml" })
public class BeanXMLTest {
	@Autowired
	private Student student;
	@Test
	public void testXMLBean() throws Exception {
		System.out.println(student.toString());
	}
	@Autowired
	private Animous dog;
	@Autowired
	private Animous cat;
	@Autowired
	private Pig pig;
	/**
	 * 测试简单工厂方法
	 * @throws Exception
	 */
	@Test
	public void testFactoryBean() throws Exception {
		System.out.println(dog.getName());
		System.out.println(cat.getName());
		//实例工厂方法
		System.out.println(pig.getName());
	}
}
