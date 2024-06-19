package com.bitconex.bitquiz.controllers;

import com.bitconex.bitquiz.controller.PlayingQuizController;
import com.bitconex.bitquiz.services.PlayingQuizService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = PlayingQuizController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class PlayingQuizControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayingQuizService quizService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private PlayingQuizControllerTests playingQuizControllerTests;

    @Test
    public void testGetQuizQuestionsByQuizId() throws Exception {
        int quizId = 1;

        when(quizService.getQuizQuestionsByQuizId(quizId)).thenReturn(Collections.emptyList());

        ResultActions response = mockMvc.perform(get("/bit/playing/{quizId}/questions", quizId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetQuizResponsesByQuestionId() throws Exception {
        long questionId = 1;

        when(quizService.getQuizResponsesByQuestionId(questionId)).thenReturn(Collections.emptyList());

        ResultActions response = mockMvc.perform(get("/bit/playing/questions/{questionId}/responses", questionId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetQuizProgressByUserId() throws Exception {
        int userId = 1;

        when(quizService.getQuizProgressByUserId(userId)).thenReturn(Collections.emptyList());

        ResultActions response = mockMvc.perform(get("/bit/playing/users/{userId}/progress", userId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
