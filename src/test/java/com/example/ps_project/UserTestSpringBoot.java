package com.example.ps_project;


import com.example.ps_project.controller.UserController;
import com.example.ps_project.entity.NormalUser;
import com.example.ps_project.entity.User;
import com.example.ps_project.repository.UserRepository;
import com.example.ps_project.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserTestSpringBoot {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testAddUser() throws Exception {
        User newUser = UserTest.newNormalUser();

        doNothing().when(userRepository).addItem(newUser);

        userService.addNewItem(newUser);
    }

    @Test
    void testGetAllUsers() throws Exception{
        List<User> userList = UserTest.createUserList();
        when(userRepository.findAllItems()).thenReturn(userList);

        Assertions.assertEquals(userList, userService.getItems());
    }

    @Test
    void testDeleteUser() throws Exception{
        doNothing().when(userRepository).deleteById(1L);

        userService.delete(1L);
    }

}
