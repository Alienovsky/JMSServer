package com.madebykamil.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@XStreamAlias("catalog")
public class Catalog implements Serializable{
    private static final long serialVersionUID = 12L;
    @XStreamImplicit(itemFieldName = "book")
    private List<Book> books = new ArrayList<Book>();

    public Catalog(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
