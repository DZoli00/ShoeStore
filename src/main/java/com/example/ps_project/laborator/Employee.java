package com.example.ps_project.laborator;

public class Employee extends User {

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Employee() {
    }

    @Override
    public int numarZile() {
        return dataSource.zile() + 23;
    }

    @Override
    public boolean equals(Object o) {
        return ((Employee) o).FirstName.equals(this.FirstName) && ((Employee) o).LastName.equals(this.LastName);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
