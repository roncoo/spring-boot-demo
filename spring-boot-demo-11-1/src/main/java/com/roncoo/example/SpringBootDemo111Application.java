package com.roncoo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo111Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo111Application.class, args);
	}
}
