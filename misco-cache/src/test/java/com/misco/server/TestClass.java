package com.misco.server;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.misco.server.mapper.UserMapper;

/**
 * @author liuwei
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MiscoConsuPoductApplication.class)
public class TestClass {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test1() {
		System.out.printf("获取用户：%s",userMapper.getUser(1l).toString());
	}

}
