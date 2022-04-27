package com.example.ps_project.laborator;

public class Visitator extends User{

    public Visitator(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Visitator() {
    }

    @Override
    public int numarZile() {
        return dataSource.zile() * 15;
    }

    @Override
    public boolean equals(Object o){
        return ((Visitator)o).FirstName.equals(this.FirstName) && ((Visitator)o).LastName.equals(this.LastName);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
