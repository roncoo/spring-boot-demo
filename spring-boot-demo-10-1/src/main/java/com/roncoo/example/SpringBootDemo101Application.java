package com.roncoo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo101Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo101Application.class, args);
	}
}
