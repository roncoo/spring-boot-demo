package com.roncoo.education;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 在Servlet容器中部署WAR的时候，不能依赖于Application的main函数而是要以类似于web.xml文件配置的方式来启动Spring应用上下文<br/>
 * 所以此时需要声明这样一个类或者将应用的主类改为继承SpringBootServletInitializer也可以
 * 
 * @author wujing
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootDemo81Application.class);
	}

}
