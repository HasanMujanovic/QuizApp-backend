package com.bitconex.bitquiz.controllers;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.MakeQuizDto;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.MakeQuizRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.quizzesRequest.QuizRequest;
import com.bitconex.bitquiz.controller.MakeQuizController;
import com.bitconex.bitquiz.services.DoneQuizService;
import com.bitconex.bitquiz.services.QuizService;
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

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = MakeQuizController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class MakeQuizControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizService quizService;

    @MockBean
    private DoneQuizService doneQuizService;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private MakeQuizController makeQuizController;

    @Test
    public void testMakeQuiz() throws Exception {
        MakeQuizRequest makeQuizRequest = new MakeQuizRequest();

        ResultActions response = mockMvc.perform(post("/bit/make-quiz/make")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(makeQuizRequest)));

        response.andExpect(MockMvcResultMatchers.status().isOk());

        verify(quizService).makeQuiz(Mockito.any(MakeQuizDto.class));
    }

    @Test
    public void testEditQuiz() throws Exception {
        QuizRequest quizRequest = new QuizRequest();

        ResultActions response = mockMvc.perform(post("/bit/make-quiz/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quizRequest)));

        response.andExpect(MockMvcResultMatchers.status().isOk());

        verify(quizService).editQuiz(Mockito.any(QuizDTO.class));
    }

}
