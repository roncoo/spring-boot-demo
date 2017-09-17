package com.roncoo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo241Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo241Application.class, args);
	}
}
