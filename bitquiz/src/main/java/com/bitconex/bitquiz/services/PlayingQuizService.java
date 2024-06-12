package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;

import java.util.List;

public interface PlayingQuizService {
    List<QuizQuestionsDTO> getQuizQuestionsByQuizId(int quizId);
    List<QuizResponseDTO> getQuizResponsesByQuestionId(long questionId);
    List<QuizProgressDTO> getQuizProgressByUserId(int userId);
}
