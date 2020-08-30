package com.SpringRabbitListner.SpringListenerAMQP;


import org.springframework.amqp.core.Queue;
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
    Queue sampleQueue(){
        return new Queue(sampleQueue,true);
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
        simpleMessageListenerContainer.setQueues(sampleQueue());
        simpleMessageListenerContainer.setMessageListener(new SimpleListener());
        return  simpleMessageListenerContainer;
    }
}
