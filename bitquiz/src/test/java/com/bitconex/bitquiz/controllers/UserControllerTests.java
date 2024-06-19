package com.bitconex.bitquiz.controllers;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.userResponse.UserResponse;
import com.bitconex.bitquiz.PasswordSecurity.CredentialsDTO;
import com.bitconex.bitquiz.PasswordSecurity.RegisterDTO;
import com.bitconex.bitquiz.controller.UserController;
import com.bitconex.bitquiz.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private UserDTO userDTO;
    private UserResponse userResponse;

    @BeforeEach
    public void setup() {
        userDTO = UserDTO.builder().name("John Doe").email("john.doe@example.com").build();
        userResponse = UserDTO.dtoToResponse(userDTO);
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        String userEmail = "test@example.com";

        when(userService.getUser(userEmail)).thenReturn(userDTO);

        ResultActions response = mockMvc.perform(get("/bit/user/getByEmail/{email}", userEmail)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(userResponse.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(userResponse.getEmail())));
    }

    @Test
    public void testGetUserById() throws Exception {
        int userId = 1;

        when(userService.getUserById(userId)).thenReturn(userDTO);

        ResultActions response = mockMvc.perform(get("/bit/user/getById/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(userResponse.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(userResponse.getEmail())));
    }

    @Test
    public void testSaveStatus() throws Exception {
        String status = "active";
        String userEmail = "test@example.com";

        ResultActions response = mockMvc.perform(post("/bit/user/save-status/{status}/{email}", status, userEmail)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService).saveUserStatus(status, userEmail);
    }

    @Test
    public void testGetTop5UsersSortedByLevelAndPoints() throws Exception {
        when(userService.getTop5UsersSortedByLevelAndPoints()).thenReturn(Collections.singletonList(userDTO));

        ResultActions response = mockMvc.perform(get("/bit/user/sorted")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", CoreMatchers.is(userResponse.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email", CoreMatchers.is(userResponse.getEmail())));
    }

    @Test
    public void testLogin() throws Exception {
        CredentialsDTO credentialsDTO = new CredentialsDTO("test@example.com", "password");

        when(userService.loginAuth(credentialsDTO)).thenReturn(userDTO);

        ResultActions response = mockMvc.perform(post("/bit/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(credentialsDTO)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(userResponse.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(userResponse.getEmail())));
    }

    @Test
    public void testRegister() throws Exception {
        RegisterDTO registerDTO = RegisterDTO.builder().userDTO(userDTO).password("password").build();

        when(userService.register(registerDTO)).thenReturn(userDTO);

        ResultActions response = mockMvc.perform(post("/bit/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerDTO)));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(userResponse.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(userResponse.getEmail())));
    }
}
