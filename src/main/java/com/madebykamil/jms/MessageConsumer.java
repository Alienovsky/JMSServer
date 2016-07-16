package com.madebykamil.jms;

import com.madebykamil.model.Person;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            final TextMessage textMeocssage = (TextMessage) message;
            Person p = new Person("Kamil","T","1111","2222",1);
            messageSender.send(p);
        }
    }
}