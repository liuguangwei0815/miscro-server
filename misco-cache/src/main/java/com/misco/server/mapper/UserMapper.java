package com.misco.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.misco.server.bean.User;

@Mapper // 声明为Maper
public interface UserMapper {
	@Select("select * from user where  id = #{id}")
	public User getUser(Long id);
	@Update("update user set password = #{password} where id = #{id}")
	public User updateUser(User user);
}
