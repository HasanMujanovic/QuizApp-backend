package com.bitconex.bitquiz.architecture.dto.mappers.toEntity;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizProgressDTO;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizProgressMapper implements Function<QuizProgressDTO, QuizProgress> {
    @Autowired
    UserRepo userRepo;
    @Override
    public QuizProgress apply(QuizProgressDTO quizProgressDTO) {
        QuizProgress progress = new QuizProgress();
        progress.setId(quizProgressDTO.getId());
        progress.setPoints(quizProgressDTO.getPoints());
        progress.setTime(quizProgressDTO.getTime());
        progress.setQuestionsAnswered(quizProgressDTO.getQuestionsAnswered());
        progress.setQuizId(quizProgressDTO.getQuizId());
        progress.setWrongAns(quizProgressDTO.getWrongAns());
        progress.setCorrectAns(quizProgressDTO.getCorrectAns());
        progress.setSkippedAns(quizProgressDTO.getSkippedAns());



        return progress;    }
}
