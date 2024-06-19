package com.bitconex.bitquiz.controllers;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddDoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.AddDoneQuizRequest;
import com.bitconex.bitquiz.controller.DoneQuizController;
import com.bitconex.bitquiz.services.DoneQuizService;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = DoneQuizController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class DoneQuizControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoneQuizService doneQuizService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private DoneQuizController doneQuizController;

    @Test
    public void testMakeQuiz() throws Exception {
        AddDoneQuizRequest addDoneQuizRequest = new AddDoneQuizRequest();

        ResultActions response = mockMvc.perform(post("/bit/done-quizes/make")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addDoneQuizRequest)));

        response.andExpect(MockMvcResultMatchers.status().isOk());

        verify(doneQuizService).addDoneQuiz(Mockito.any(AddDoneQuizDTO.class));
    }

    @Test
    public void testGetLeaderboardForQuiz() throws Exception {
        int quizId = 1;

        ResultActions response = mockMvc.perform(get("/bit/done-quizes/{quizId}/doneQuiz", quizId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());

        verify(doneQuizService).getSortedLeaderboard(quizId, 5);
    }

    @Test
    public void testGetDoneQuizzesByUserId() throws Exception {
        int userId = 1;

        List<DoneQuizDTO> doneQuizzes = new ArrayList<>();

        when(doneQuizService.getDoneQuizzesByUserId(userId)).thenReturn(doneQuizzes);

        ResultActions response = mockMvc.perform(get("/bit/done-quizes/user/{userId}", userId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());

        verify(doneQuizService).getDoneQuizzesByUserId(userId);
    }
}
