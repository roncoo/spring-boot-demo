package com.roncoo.education.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.roncoo.education.bean.RoncooUser;

@Mapper
public interface RoncooUserMapper {

	@Insert(value = "insert into roncoo_user (name, create_time) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
	int insert(RoncooUser record);

	@Select(value = "select id, name, create_time from roncoo_user where id = #{id,jdbcType=INTEGER}")
	@Results(value = { @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	RoncooUser selectByPrimaryKey(Integer id);
}
