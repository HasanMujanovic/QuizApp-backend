package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class QuizDTOMapper implements Function<Quiz, QuizDTO> {
    @Override
    public QuizDTO apply(Quiz quiz) {
        QuizDTO dto = new QuizDTO();
        dto.setId(quiz.getId());
        dto.setCategory(quiz.getCategory());
        dto.setStatus(quiz.getStatus());
        dto.setDifficulty(quiz.getDifficulty());
        dto.setName(quiz.getName());
        dto.setLikes(quiz.getLikes());
        dto.setDoneIt(quiz.getDoneIt());
        dto.setTime(quiz.getTime());
        dto.setPoints(quiz.getPoints());
        return dto;
    }
}
