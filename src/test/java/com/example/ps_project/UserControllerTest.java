package com.example.ps_project;

import com.example.ps_project.controller.UserController;
import com.example.ps_project.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserController userController;

    void GetAllUsersTest() throws Exception {

    }


    @Test
    void addNormalUserTest() throws Exception {
        User newUser = UserTest.addNormalUserMethod();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/NORMALUSER").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(newUser))).andExpect(status().isOk());
    }

    @Test
    void addAdminTest() throws Exception {
        User newUser = UserTest.addAdminMethod();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/ADMIN").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(newUser))).andExpect(status().isOk());
    }

    @Test
    void getUsersTest() throws Exception {
        List<User> userList = UserTest.createUserList();

        Mockito.when(userController.getUsers()).thenReturn(userList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Zoltan"))
                .andExpect(jsonPath("$[0].lastName").value("Darlaczi"))
                .andExpect(jsonPath("$[0].email").value("darlaczi.zoltan@gmail.com"))
                .andExpect(jsonPath("$[0].address").value("Observator"))
                .andExpect(jsonPath("$[0].orderLists").value(nullValue()))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firstName").value("Abdulah"))
                .andExpect(jsonPath("$[1].lastName").value("Lahman"))
                .andExpect(jsonPath("$[1].email").value("naruto@yahoo.com"))
                .andExpect(jsonPath("$[1].address").value("Cluj-Napoca"))
                .andExpect(jsonPath("$[1].orderLists").value(nullValue()))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].firstName").value("James"))
                .andExpect(jsonPath("$[2].lastName").value("Hardy"))
                .andExpect(jsonPath("$[2].email").value("asus2015@gmail.com"))
                .andExpect(jsonPath("$[2].address").value("Bistrita"))
                .andExpect(jsonPath("$[2].orderLists").value(nullValue()));
    }

    @Test
    void updateUserTest() throws Exception {

        User newUser = UserTest.newNormalUser();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/NORMALUSER").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(newUser))).andExpect(status().isOk());


        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user/1?first_name=Ronaldo")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }


    @Test
    void deleteUserByIdTest() throws Exception {

        User newUser = UserTest.addNormalUserMethod();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/NORMALUSER").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(newUser))).andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/user/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}
