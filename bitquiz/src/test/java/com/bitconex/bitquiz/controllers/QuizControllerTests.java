package com.bitconex.bitquiz.controllers;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.controller.QuizController;
import com.bitconex.bitquiz.services.QuizService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(controllers = QuizController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class QuizControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizService quizService;

    @Test
    public void testGetAllQuizes() throws Exception {
        when(quizService.getAllQuiz()).thenReturn(Collections.emptyList());

        ResultActions response = mockMvc.perform(get("/bit/quiz/getAll")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetQuizById() throws Exception {
        int quizId = 1;

        when(quizService.getQuizById(quizId)).thenReturn(new QuizDTO());

        ResultActions response = mockMvc.perform(get("/bit/quiz/{id}", quizId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetQuizzesByUserId() throws Exception {
        int userId = 1;

        when(quizService.getQuizesMadeByUser(userId)).thenReturn(Collections.emptyList());

        ResultActions response = mockMvc.perform(get("/bit/quiz/{userId}/quizzes", userId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAdminByQuizId() throws Exception {
        int quizId = 1;

        when(quizService.getAdminByQuizId(quizId)).thenReturn(new UserDTO());

        ResultActions response = mockMvc.perform(get("/bit/quiz/{quizId}/admin", quizId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteQuiz() throws Exception {
        int quizId = 1;
        int userId = 1;

        mockMvc.perform(delete("/bit/quiz/{quizId}/user/{userId}/delete", quizId, userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(quizService).deleteQuiz(quizId, userId);
    }

    @Test
    public void testLikeQuiz() throws Exception {
        int quizId = 1;

        mockMvc.perform(post("/bit/quiz/{quizId}/like", quizId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(quizService).likeingQuiz(quizId);
    }

    @Test
    public void testGetFilteredQuizzes() throws Exception {
        String category = "Science";
        String difficulty = "Easy";

        when(quizService.filteredQuizes(category, difficulty)).thenReturn(Collections.emptyList());

        ResultActions response = mockMvc.perform(get("/bit/quiz/filtered")
                .param("category", category)
                .param("difficulty", difficulty)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
