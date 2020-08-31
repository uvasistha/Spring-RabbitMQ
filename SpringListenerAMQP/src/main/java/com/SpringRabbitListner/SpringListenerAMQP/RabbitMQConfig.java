package com.SpringRabbitListner.SpringListenerAMQP;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static String sampleQueue = "sampleQueue";

    //Creating Queue for rabbitMQ
    @Bean
    Queue configQueue(){
        return new Queue(sampleQueue,true);
    }

    //Create Exchange
    @Bean
    Exchange configExchange(){
        return ExchangeBuilder.topicExchange("sampleTopicExchange").autoDelete().durable(true).build();
    }

    //Binding sampleQueue to sampleTopicExchange with sample routingKey
    @Bean
    Binding configBinding(){
       // return new Binding(sampleQueue,Binding.DestinationType.QUEUE,"sample topic exchange","sample",null);
        return BindingBuilder
                .bind(configQueue())
                .to(configExchange())
                .with("sample")
                .noargs();
    }

    //Creating connection to broker
    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return  cachingConnectionFactory;
    }

    //bind all together
    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(configQueue());
        simpleMessageListenerContainer.setMessageListener(new SimpleListener());
        return  simpleMessageListenerContainer;
    }
}
