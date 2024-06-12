package com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DoneQuizDTOMapper implements Function<DoneQuiz, DoneQuizDTO> {
    @Override
    public DoneQuizDTO apply(DoneQuiz doneQuiz) {
        DoneQuizDTO dto = new DoneQuizDTO();
        dto.setId(doneQuiz.getId());
        dto.setPointsWon(doneQuiz.getPointsWon());
        dto.setTimeLeft(doneQuiz.getTimeLeft());
        dto.setUserIdForSearch(doneQuiz.getUserIdForSearch());
        dto.setQuizIdForSearch(doneQuiz.getQuizIdForSearch());
        dto.setUsername(doneQuiz.getUsername());
        return dto;
    }
}
