package com.example.Week7.controllers;

import com.example.Week7.pojos.ApiResponse;
import com.example.Week7.pojos.UserDto;
import com.example.Week7.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserService userService;


    @Test
    void createUser() throws Exception {

            UserDto newUser = new UserDto();
            newUser.setName("Jhon Doe");
            newUser.setEmail("jhondoe@gmail.com");
            newUser.setPassword("1234");

            String requestBody = mapper.writeValueAsString(newUser);

            mockMvc.perform(post("/api/v1/user/signup", 42L)
                            .contentType("application/json").content(requestBody))
                    .andExpect(status().isOk());

    }


    @After
    public void tearDown(){

    }
}