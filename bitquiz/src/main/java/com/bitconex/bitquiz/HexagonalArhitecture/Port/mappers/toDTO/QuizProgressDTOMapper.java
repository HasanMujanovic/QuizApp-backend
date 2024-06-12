package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.entity.QuizProgress;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizProgressDTOMapper implements Function<QuizProgress, QuizProgressDTO> {


    @Override
    public QuizProgressDTO apply(QuizProgress quizProgress) {
        QuizProgressDTO dto = new QuizProgressDTO();
        dto.setId(quizProgress.getId());
        dto.setPoints(quizProgress.getPoints());
        dto.setTime(quizProgress.getTime());
        dto.setQuestionsAnswered(quizProgress.getQuestionsAnswered());
        dto.setQuizId(quizProgress.getQuizId());
        dto.setSkippedAns(quizProgress.getSkippedAns());
        dto.setCorrectAns(quizProgress.getCorrectAns());
        dto.setWrongAns(quizProgress.getWrongAns());
        return dto;
    }
}
