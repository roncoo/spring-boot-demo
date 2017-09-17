package com.roncoo.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roncoo.example.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo151ApplicationTests {
	
	
	@Autowired
	private UserService userService;

	@Test
	public void register() {
		String result = userService.register("无境", "192.168.1.1");
		System.out.println(result);
	}


}
