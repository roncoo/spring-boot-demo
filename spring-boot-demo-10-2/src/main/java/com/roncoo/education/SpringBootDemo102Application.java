package com.roncoo.education;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import com.roncoo.education.util.filter.CustomFilter;
import com.roncoo.education.util.listener.CustomListener;
import com.roncoo.education.util.servlet.CustomServlet;

@SpringBootApplication
public class SpringBootDemo102Application implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addServlet("customServlet", new CustomServlet()).addMapping("/roncoo");
		servletContext.addFilter("customFilter", new CustomFilter())
				.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
		servletContext.addListener(new CustomListener());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo102Application.class, args);
	}
}
