package com.roncoo.example.util.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jms 队列配置
 * 
 * @author wujing
 */
@Configuration
public class JmsConfiguration {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("roncoo.queue");
	}

}

