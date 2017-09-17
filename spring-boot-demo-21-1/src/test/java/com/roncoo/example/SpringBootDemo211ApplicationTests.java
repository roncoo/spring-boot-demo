package com.roncoo.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roncoo.example.component.RoncooJmsComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo211ApplicationTests {
	@Autowired
	private RoncooJmsComponent roncooJmsComponent;

	@Test
	public void send() {
		roncooJmsComponent.send("hello world");
	}



}
