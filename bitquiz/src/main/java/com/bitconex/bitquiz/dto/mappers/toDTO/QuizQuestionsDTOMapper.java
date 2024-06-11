package com.bitconex.bitquiz.dto.mappers.toDTO;

import com.bitconex.bitquiz.dto.QuizQuestionsDTO;
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
        return dto;
    }
}
