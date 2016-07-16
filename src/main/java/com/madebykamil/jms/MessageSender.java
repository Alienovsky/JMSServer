package com.madebykamil.jms;

import com.madebykamil.model.Book;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.ArrayList;
import java.util.List;

public class MessageSender {
    private final JmsTemplate jmsTemplate;

    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final Book book){
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(book);
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final List<Book> books){
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(new ArrayList<Book>(books));
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final String textMessage){
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(textMessage);
            }
        };
        jmsTemplate.send(messageCreator);
    }
}
