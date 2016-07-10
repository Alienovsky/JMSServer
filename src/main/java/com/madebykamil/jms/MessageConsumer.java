package com.madebykamil.jms;

import com.madebykamil.model.Person;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            final TextMessage textMessage = (TextMessage) message;
            Person p = new Person("Kamil","T","1111","2222",1);
            messageSender.send(p);
        }

    }
}
