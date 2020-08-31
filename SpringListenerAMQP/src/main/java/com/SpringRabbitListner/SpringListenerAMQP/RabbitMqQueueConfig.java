package com.SpringRabbitListner.SpringListenerAMQP;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqQueueConfig {

    //simple way
    @Bean
    Queue getQueue(){
        return new Queue("config simple queue way 1",false);
    }
    //builder way
    @Bean
    Queue getQueuefromBuilder(){
        return QueueBuilder.durable("config simple  builder queue way 1").autoDelete().exclusive().build();
    }
}
