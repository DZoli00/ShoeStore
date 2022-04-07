package com.example.ps_project;

import com.example.ps_project.laborator.FactoryUser;
import com.example.ps_project.laborator.User;
import com.example.ps_project.laborator.Users;
import com.example.ps_project.laborator.Visitator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.Assert.assertEquals;

@SpringBootTest
class PsProjectApplicationTests {

    @Test
    void contextLoads() {
        FactoryUser factoryUser = new FactoryUser();
        User user = factoryUser.create(Users.VISITATOR, "obu", "obu");
        User expectedUser = new Visitator("obu", "obu");

        assertEquals(user,expectedUser);

    }

}
