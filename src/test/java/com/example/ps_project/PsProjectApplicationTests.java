package com.example.ps_project;

import com.example.ps_project.laborator.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PsProjectApplicationTests {

    @Mock
    DataSource dataSourceMock;

    @Test
    void contextLoads() {
        FactoryUser factoryUser = new FactoryUser();
        User user = factoryUser.create(Users.VISITATOR, "obu", "obu");
        User expectedUser = new Visitator("obu", "obu");

        assertEquals(user,expectedUser);

    }

    @Test
    void test2(){
        when(dataSourceMock.zile()).thenReturn(15);

        FactoryUser fact = new FactoryUser();
        User u = fact.create(Users.VISITATOR,"obu","obu");
        u.dataSource = dataSourceMock;

        int expected = u.numarZile();
        assertEquals(225, expected);
        verify(dataSourceMock,times(1)).zile();
    }

}
