package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;
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
        return dto;
    }
}
