package com.example.ps_project.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@Entity
public class Admin extends User{

    public Admin(String firstName, String lastName, String email, String address) {
        super(firstName, lastName, email, address);
    }

    public Admin(String first_name, String last_name, String email) {
        super(first_name, last_name, email);
    }

    public Admin() {
    }

    public Admin(Long id, String firstName, String lastName, String email, String address) {
        super(id, firstName, lastName, email, address);
    }

    public Admin(Long id, String firstName, String lastName, String email, String address, List<OrderList> orderLists) {
        super(id, firstName, lastName, email, address, orderLists);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Admin)obj).getFirstName().equals(this.getFirstName()) && ((Admin)obj).getLastName().equals(this.getLastName())
                && ((Admin)obj).getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
