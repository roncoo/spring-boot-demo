package com.roncoo.example.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wujing
 */
@Component
public class RoncooAmqpComponent {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String msg) {
		this.amqpTemplate.convertAndSend("roncoo.queue", msg);
	}

	@RabbitListener(queues = "roncoo.queue")
	public void receiveQueue(String text) {
		System.out.println("接受到：" + text);
	}

}
