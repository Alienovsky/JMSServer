package com.madebykamil.jms;

import com.madebykamil.jms.responses.AddBookResponse;
import com.madebykamil.jms.responses.GetAllBooksResponse;
import com.madebykamil.jms.responses.GetBookByIdResponse;
import com.madebykamil.jms.responses.RemoveBookResponse;
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

    public void send(final GetAllBooksResponse response) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(response);
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final GetBookByIdResponse response) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(response);
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final AddBookResponse response) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(response);
            }
        };
        jmsTemplate.send(messageCreator);
    }

    public void send(final RemoveBookResponse response) {
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(response);
            }
        };
        jmsTemplate.send(messageCreator);
    }
}
