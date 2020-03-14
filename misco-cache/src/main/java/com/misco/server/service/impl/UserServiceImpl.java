package com.misco.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.misco.server.bean.User;
import com.misco.server.mapper.UserMapper;
import com.misco.server.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * value/cacheNames 一样 指定缓存的到哪里的名字 给缓存取个名字
	 * key 和  keyGenerator 只能二选一，key 默认去的
	 * 
	 * cacheManager 缓存管理区  比如一个是redis 或者 ehcache  或者 是  cacheResolver  他们的意思都一样
	 * condition ： 指定符合条件 才缓存 condition = "#id>0" 当id 》 0 才进行缓存
	 * 
	 * unless： 除非 ，都进行缓存，除非 unless = "#result==null" 当缓存为null 不进行缓存
	 */
	@Override
	//将当前结果放到缓存
	@Cacheable(cacheNames = {"user"})
	public User getUser(Long id) {
		return userMapper.getUser(id);
	}
}
