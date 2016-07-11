package com.madebykamil.model;

import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    String name;
    String surname;
    String phone;
    String fax;

    public Person(String name, String surname, String phone, String fax, int id) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.fax = fax;
        this.id = id;
    }

    int id;
}