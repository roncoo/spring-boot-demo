package com.roncoo.education;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roncoo.education.bean.RoncooUser;
import com.roncoo.education.mapper.RoncooUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo281ApplicationTests {

	@Autowired
	private RoncooUserMapper mapper;

	@Test
	public void insert() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName("测试");
		roncooUser.setCreateTime(new Date());
		int result = mapper.insert(roncooUser);
		System.out.println(result);
	}

}
