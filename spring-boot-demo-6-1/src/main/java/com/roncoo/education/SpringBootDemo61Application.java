package com.roncoo.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo61Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo61Application.class, args);
	}
}
