package com.rabbitspring.SpringRabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitMqApplication implements CommandLineRunner {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rabbitTemplate.convertAndSend("TestExchange","testRouting","Sample Spring Message");
	}
}
