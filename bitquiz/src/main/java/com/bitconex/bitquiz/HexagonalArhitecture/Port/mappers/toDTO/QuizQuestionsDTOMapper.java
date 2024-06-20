package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO;

import com.bitconex.bitquiz.entity.QuizQuestions;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizQuestionsDTOMapper implements Function<QuizQuestions, com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO> {
    @Override
    public com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO apply(QuizQuestions quizQuestions) {
        com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO dto = new com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO();
        dto.setId(quizQuestions.getId());
        dto.setText(quizQuestions.getText());
        dto.setPoints(quizQuestions.getPoints());
        dto.setHelpAllowed(quizQuestions.isHelpAllowed());
        dto.setMinusPoints(quizQuestions.getMinusPoints());
        return dto;
    }
}
