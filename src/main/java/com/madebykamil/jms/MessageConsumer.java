package com.madebykamil.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void onMessage(Message message) {
        messageSender.send("I got the message");
    }
}
