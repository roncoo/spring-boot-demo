package com.roncoo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;

@EnableJms 
@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo211Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo211Application.class, args);
	}
}
