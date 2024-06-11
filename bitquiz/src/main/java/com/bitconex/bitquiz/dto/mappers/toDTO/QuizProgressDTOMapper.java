package com.bitconex.bitquiz.dto.mappers.toDTO;

import com.bitconex.bitquiz.dto.QuizProgressDTO;
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
        dto.setTimeOfSaving(quizProgress.getTimeOfSaving());
        dto.setQuizId(quizProgress.getQuizId());
        return dto;
    }
}
