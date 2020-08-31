package com.SpringRabbitListner.SpringListenerAMQP;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class SimpleListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if(message.getClass().isInstance(SimpleMessage.class)){
            System.out.println(message.getBody());
        }

        System.out.println("This is the message received : " + new String(message.getBody()));
    }
}
