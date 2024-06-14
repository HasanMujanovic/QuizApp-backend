package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.MakeQuizDto;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;

import java.util.List;

public interface QuizService {
    void makeQuiz(MakeQuizDto makeQuizDto);
    void editQuiz(QuizDTO quizDTO);
    List<QuizDTO> getAllQuiz();
    QuizDTO getQuizById(int quizId);
    List<QuizDTO>getQuizesMadeByUser(int userId);
    UserDTO getAdminByQuizId(int quizId);
    void deleteQuiz(int quizId, int userId);
    void likeingQuiz(int quizId);
    List<QuizDTO> filteredQuizes(String category, String difficulty);

}
