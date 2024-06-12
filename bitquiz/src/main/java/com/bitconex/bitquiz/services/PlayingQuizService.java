package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizProgressDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizResponseDTO;

import java.util.List;

public interface PlayingQuizService {
    List<QuizQuestionsDTO> getQuizQuestionsByQuizId(int quizId);
    List<QuizResponseDTO> getQuizResponsesByQuestionId(long questionId);
    List<QuizProgressDTO> getQuizProgressByUserId(int userId);
}
