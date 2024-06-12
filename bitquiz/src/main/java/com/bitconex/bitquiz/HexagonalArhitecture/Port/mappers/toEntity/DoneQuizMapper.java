package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DoneQuizMapper implements Function<DoneQuizDTO, DoneQuiz> {
    @Override
    public DoneQuiz apply(DoneQuizDTO doneQuizDTO) {
        DoneQuiz doneQuiz = new DoneQuiz();
        doneQuiz.setId(doneQuizDTO.getId());
        doneQuiz.setPointsWon(doneQuizDTO.getPointsWon());
        doneQuiz.setTimeLeft(doneQuizDTO.getTimeLeft());
        doneQuiz.setUserIdForSearch(doneQuizDTO.getUserIdForSearch());
        doneQuiz.setQuizIdForSearch(doneQuizDTO.getQuizIdForSearch());
        doneQuiz.setUsername(doneQuizDTO.getUsername());


        return doneQuiz;
    }
}
