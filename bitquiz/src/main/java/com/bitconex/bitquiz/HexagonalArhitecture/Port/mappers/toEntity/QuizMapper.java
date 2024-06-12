package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizMapper implements Function<QuizDTO, Quiz> {
    @Override
    public Quiz apply(QuizDTO dto) {
        Quiz quiz = new Quiz();
        quiz.setId(dto.getId());
        quiz.setCategory(dto.getCategory());
        quiz.setStatus(dto.getStatus());
        quiz.setDifficulty(dto.getDifficulty());
        quiz.setName(dto.getName());
        quiz.setLikes(dto.getLikes());
        quiz.setDoneIt(dto.getDoneIt());
        quiz.setTime(dto.getTime());
        quiz.setPoints(dto.getPoints());

        return quiz;
    }
}
