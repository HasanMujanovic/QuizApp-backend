package com.bitconex.bitquiz.controllers;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.AddQuizProgressRequest;
import com.bitconex.bitquiz.controller.QuizProgressController;
import com.bitconex.bitquiz.services.SaveProgressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = QuizProgressController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class QuizProgressControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaveProgressService saveProgressService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private QuizProgressControllerTests quizProgressControllerTests;

    @Test
    public void testSaveQuizProgress() throws Exception {
        AddQuizProgressRequest addQuizProgressRequest = new AddQuizProgressRequest();
        UserDTO userDTO = UserDTO.builder().name("John Doe").email("john.doe@example.com").build();

        QuizProgressDTO quizProgressDTO = Mockito.mock(QuizProgressDTO.class);
        addQuizProgressRequest.setUser(userDTO);
        addQuizProgressRequest.setQuizProgress(quizProgressDTO);

        String requestBody = objectMapper.writeValueAsString(addQuizProgressRequest);

        ResultActions response = mockMvc.perform(post("/bit/quiz-progress/make")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        response.andExpect(MockMvcResultMatchers.status().isOk());

    }
}
