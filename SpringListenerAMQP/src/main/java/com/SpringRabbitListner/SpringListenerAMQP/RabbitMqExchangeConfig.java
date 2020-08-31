package com.SpringRabbitListner.SpringListenerAMQP;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqExchangeConfig {

    @Bean
    Exchange configExchange2(){
        return ExchangeBuilder.directExchange("config direct exchange").autoDelete().internal().build();
    }

    @Bean
    Exchange configExchange3(){
        return ExchangeBuilder.topicExchange("config topic exchange").autoDelete().internal().durable(true).build();
    }
    @Bean
    Exchange configExchange4(){
        return ExchangeBuilder.fanoutExchange("config fan out exchange").build();
    }
}
