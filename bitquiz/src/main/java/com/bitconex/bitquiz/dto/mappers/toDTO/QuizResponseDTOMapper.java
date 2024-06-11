package com.bitconex.bitquiz.dto.mappers.toDTO;

import com.bitconex.bitquiz.dto.QuizResponseDTO;
import com.bitconex.bitquiz.entity.QuizResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizResponseDTOMapper implements Function<QuizResponse, QuizResponseDTO> {
    @Override
    public QuizResponseDTO apply(QuizResponse quizResponse) {
        QuizResponseDTO dto = new QuizResponseDTO();
        dto.setId(quizResponse.getId());
        dto.setText(quizResponse.getText());
        dto.setCorrectAnswer(quizResponse.isCorrectAnswer());
        dto.setQuestionId(quizResponse.getQuestions().getId());
        return dto;
    }
}
