package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dto.MakeQuizDto;
import com.bitconex.bitquiz.entity.Quiz;

public interface QuizService {
    void makeQuiz(MakeQuizDto makeQuizDto);
    void editQuiz(Quiz quizService);

}
