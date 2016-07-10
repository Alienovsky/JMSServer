package com.madebykamil.jms;

import com.madebykamil.model.Person;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

public class MessageSender {
    private final JmsTemplate jmsTemplate;

    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final Person person){
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(person);
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
