package com.example.ps_project.laborator;

public class FactoryUser {

    public User create(Users users, String fname, String lname){
        if(users.equals(Users.VISITATOR)){
            return new Visitator(fname, lname);
        } else {
            if (users.equals(Users.EMPLOYEE)) {
                return new Employee(fname, lname);
            } else {
                if(users.equals(Users.CONTRACTOR)) {
                    return new Contractor(fname, lname);
                }
            }
        }
        return null;
    }
}
