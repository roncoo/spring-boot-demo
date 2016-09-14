package com.roncoo.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.roncoo.education.util.filter.CustomFilter;
import com.roncoo.education.util.listener.CustomListener;
import com.roncoo.education.util.servlet.CustomServlet;

@SpringBootApplication
public class SpringBootDemo101Application {

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new CustomServlet(), "/roncoo");
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
	}

	@Bean
	public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<CustomListener>(new CustomListener());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo101Application.class, args);
	}
}
