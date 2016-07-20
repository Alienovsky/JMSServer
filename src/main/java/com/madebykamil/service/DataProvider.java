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

    public DataProvider() {
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

    public Book provideBook(String id) {
        if (id == null && id.isEmpty()) {
            return null;
        }
        for (Book book : catalog.getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public String addBook(String id, String authorName, String authorSurname, String title, String genre, Float price, String description) {
        if (id != null && authorName != null && authorSurname != null && title != null && genre != null && price != null && description != null) {
            if (!id.isEmpty() && !authorName.isEmpty() && !authorSurname.isEmpty() && !title.isEmpty() && !genre.isEmpty() && !description.isEmpty()) {
                Book book = new Book(id, new Author(authorName, authorSurname), title, genre, price, description);
                catalog.getBooks().add(book);
                return "";
            }
        }
        return "There was a null value, all fields must have value in Book";
    }

    public String addBook2(String id, String authorName, String authorSurname, String title, String genre, Float price, String description) {
        try{
            if (!id.isEmpty() && !authorName.isEmpty() && !authorSurname.isEmpty() && !title.isEmpty() && !genre.isEmpty() && !description.isEmpty()) {
                Book book = new Book(id, new Author(authorName, authorSurname), title, genre, price, description);
                catalog.getBooks().add(book);
                return "";
            }
        }catch (NullPointerException ex){
            return "There was a null value, all fields must have value in Book";
        }
        return "Book has not been added to the collection, there was an issue, please check the logs";
    }

    public String removeBook(String id) {
        for (Book book : catalog.getBooks()) {
            if (book.getId().equals(id)) {
                catalog.getBooks().remove(book);
                return "";
            }
        }
        return "Book was not removed, there is no such book with ID: "+id;
    }

    public List<Book> provideAllBooks() {
        return catalog.getBooks();
    }

}
