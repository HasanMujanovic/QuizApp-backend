package com.bitconex.bitquiz.dto.mappers.toEntity;

import com.bitconex.bitquiz.dto.QuizResponseDTO;
import com.bitconex.bitquiz.entity.QuizQuestions;
import com.bitconex.bitquiz.entity.QuizResponse;
import com.bitconex.bitquiz.repository.QuizQuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizResponseMapper implements Function<QuizResponseDTO, QuizResponse> {
    @Autowired
    QuizQuestionsRepo quizQuestionsRepo;
    @Override
    public QuizResponse apply(QuizResponseDTO quizResponseDTO) {
        QuizResponse response = new QuizResponse();
        response.setId(quizResponseDTO.getId());
        response.setText(quizResponseDTO.getText());
        response.setCorrectAnswer(quizResponseDTO.isCorrectAnswer());

        return response;
    }
}
