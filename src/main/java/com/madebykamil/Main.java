package com.madebykamil;

import com.madebykamil.model.Author;
import com.madebykamil.model.Book;
import com.madebykamil.model.Catalog;
import com.thoughtworks.xstream.XStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
    }
}
