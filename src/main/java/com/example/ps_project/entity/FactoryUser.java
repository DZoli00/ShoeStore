package com.example.ps_project.entity;

public class FactoryUser {

    public User create(UserType users, String fname, String lname, String email, String address) {
        if (users.equals(UserType.ADMIN)) {
            return new Admin(fname, lname, email, address);
        }
        if (users.equals(UserType.NORMALUSER)) {
            return new NormalUser(fname, lname, email, address);
        }
        return null;
    }

}
