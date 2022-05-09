package com.example.ps_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@Entity
public class NormalUser extends User{

    public NormalUser(String firstName, String lastName, String email, String address) {
        super(firstName, lastName, email, address);
    }

    public NormalUser(Long id, String first_name, String last_name, String email) {
        super(id, first_name, last_name, email);
    }

    public NormalUser(String first_name, String last_name, String email) {
        super(first_name, last_name, email);
    }

    public NormalUser() {
    }

    public NormalUser(Long id, String firstName, String lastName, String email, String address) {
        super(id, firstName, lastName, email, address);
    }

    public NormalUser(Long id, String firstName, String lastName, String email, String address, List<OrderList> orderLists) {
        super(id, firstName, lastName, email, address, orderLists);
    }

    @Override
    public boolean equals(Object obj) {
        return ((NormalUser)obj).getFirstName().equals(this.getFirstName()) && ((NormalUser)obj).getLastName().equals(this.getLastName())
                && ((NormalUser)obj).getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
