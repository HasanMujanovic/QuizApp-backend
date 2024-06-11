package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dto.MakeQuizDto;
import com.bitconex.bitquiz.dto.QuizDTO;
import com.bitconex.bitquiz.entity.Quiz;

import java.util.List;

public interface QuizService {
    void makeQuiz(MakeQuizDto makeQuizDto);
    void editQuiz(Quiz quizService);
    List<QuizDTO> getAllQuiz();
}
