package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.entity.QuizQuestions;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizQuestionsDTOMapper implements Function<QuizQuestions, QuizQuestionsDTO> {
    @Override
    public QuizQuestionsDTO apply(QuizQuestions quizQuestions) {
        QuizQuestionsDTO dto = new QuizQuestionsDTO();
        dto.setId(quizQuestions.getId());
        dto.setText(quizQuestions.getText());
        dto.setPoints(quizQuestions.getPoints());
        dto.setHelpAllowed(quizQuestions.isHelpAllowed());
        dto.setMinusPoints(quizQuestions.getMinusPoints());
        return dto;
    }
}
