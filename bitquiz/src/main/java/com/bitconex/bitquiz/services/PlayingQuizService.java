package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dto.QuizProgressDTO;
import com.bitconex.bitquiz.dto.QuizQuestionsDTO;
import com.bitconex.bitquiz.dto.QuizResponseDTO;

import java.util.List;

public interface PlayingQuizService {
    List<QuizQuestionsDTO> getQuizQuestionsByQuizId(int quizId);
    List<QuizResponseDTO> getQuizResponsesByQuestionId(long questionId);
    List<QuizProgressDTO> getQuizProgressByUserId(int userId);
}
