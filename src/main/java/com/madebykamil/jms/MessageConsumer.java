package com.madebykamil.jms;

import com.madebykamil.jms.requests.AddBookRequest;
import com.madebykamil.jms.requests.GetAllBooksRequest;
import com.madebykamil.jms.requests.GetBookByIdRequest;
import com.madebykamil.jms.requests.RemoveBookRequest;
import com.madebykamil.jms.responses.*;
import com.madebykamil.service.DataProvider;

import javax.jms.*;
import java.io.Serializable;

public class MessageConsumer implements MessageListener {

    private MessageSender messageSender;
    private DataProvider dataProvider = new DataProvider();

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                Serializable objectFromMessage = objectMessage.getObject();
                if(objectFromMessage instanceof GetAllBooksRequest){
                    GetAllBooksResponse response = new GetAllBooksResponse();
                    response.setAllBooks(dataProvider.provideAllBooks());
                    messageSender.send(response);
                }
                else if(objectFromMessage instanceof GetBookByIdRequest){
                    GetBookByIdRequest request = (GetBookByIdRequest) objectFromMessage;
                    GetBookByIdResponse response = new GetBookByIdResponse(dataProvider.provideBook(request.getBookId()));
                    messageSender.send(response);
                }
                else if(objectFromMessage instanceof AddBookRequest){
                    AddBookRequest request = (AddBookRequest) objectFromMessage;
                    String result = dataProvider.addBook("BookIdNewlyCreated",request.getAuthorName(),request.getAuthorSurname(),request.getTitle(),request.getGenre(),request.getPrice(),request.getDescription());
                    AddBookResponse response = new AddBookResponse();
                    if(result.isEmpty()){
                        response.setBookId("BookIdNewlyCreated");
                    } else {
                        response.setErrors(result);
                    }
                    messageSender.send(response);
                }
                else if(objectFromMessage instanceof RemoveBookRequest){
                    RemoveBookRequest request = (RemoveBookRequest) objectFromMessage;
                    String result = dataProvider.removeBook(request.getBookId());
                    RemoveBookResponse response = new RemoveBookResponse();
                    if(result.isEmpty()){
                        response.setBookId(request.getBookId());
                    } else {
                        response.setErrors(dataProvider.removeBook(request.getBookId()));
                    }
                    messageSender.send(response);
                }
                /*else{

                }*/
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}