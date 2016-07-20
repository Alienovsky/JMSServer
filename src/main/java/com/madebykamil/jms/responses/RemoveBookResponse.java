package com.madebykamil.jms.responses;

import java.io.Serializable;

public class RemoveBookResponse extends  AbstractResponse implements Serializable {
    private static final long serialVersionUID = 888L;
    private String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
