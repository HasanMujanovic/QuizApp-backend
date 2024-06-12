package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.architecture.dto.MakeQuizDto;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizDTO;

import java.util.List;

public interface QuizService {
    void makeQuiz(MakeQuizDto makeQuizDto);
    void editQuiz(QuizDTO quizDTO);
    List<QuizDTO> getAllQuiz();
    QuizDTO getQuizById(int quizId);
    List<QuizDTO>getQuizesMadeByUser(int userId);

}
