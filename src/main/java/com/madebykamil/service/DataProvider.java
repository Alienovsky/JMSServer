package com.madebykamil.service;

import com.madebykamil.model.Author;
import com.madebykamil.model.Book;
import com.madebykamil.model.Catalog;
import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private Catalog catalog;

    public DataProvider(){
        FileReader reader = null;  // load file
        try {
            reader = new FileReader("C:\\Kamil\\Workspace\\spock_training\\JMSServer\\src\\main\\resources\\initial-data.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(Catalog.class);     // inform XStream to parse annotations in Data class
        xstream.processAnnotations(Book.class);      // and in two other classes...
        xstream.processAnnotations(Author.class);   // we use for mappings
        this.catalog = (Catalog) xstream.fromXML(reader); // parse
    }

    public Book provideBook(String id){
        if(id == null || id.isEmpty()) {
            return null;
        }
        for(Book book : catalog.getBooks()){
            if(book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book){
        if(book!=null){
            catalog.getBooks().add(book);
        }
    }

    public boolean removeBook(String id){
        for(Book book : catalog.getBooks()){
            if(book.getId().equals(id)){
                catalog.getBooks().remove(book);
                return true;
            }
        }
        return false;
    }

    public List<Book> provideAllBooks(){
        return catalog.getBooks();
    }

}
