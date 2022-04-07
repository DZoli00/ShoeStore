package com.example.ps_project.laborator;

public class Contractor extends User{

    public Contractor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Contractor() {
    }

    @Override
    public boolean equals(Object o){
        return ((Contractor)o).FirstName.equals(this.FirstName) && ((Contractor)o).LastName.equals(this.LastName);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
