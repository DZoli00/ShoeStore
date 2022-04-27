package com.example.ps_project.laborator;

public abstract class User {

    public String FirstName = null;
    public String LastName = null;
    public DataSource dataSource;

    public User() {
    }

    public User(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
        dataSource = new Data();
    }

    public abstract int numarZile();

}
