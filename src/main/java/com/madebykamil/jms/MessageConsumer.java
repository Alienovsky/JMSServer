package com.madebykamil.jms;

import com.madebykamil.service.DataProvider;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;
    private DataProvider dataProvider = new DataProvider();

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            final TextMessage textMessage = (TextMessage) message;
            messageSender.send(dataProvider.provideAllBooks());
        }
    }
}


/*
 if (message instanceof TextMessage) {
            final TextMessage textMessage = (TextMessage) message;
            Person p = new Person("Kamil","T","1111","2222",1);
            messageSender.send(p);
        }
 */