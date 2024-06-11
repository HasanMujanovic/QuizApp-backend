package com.bitconex.bitquiz.dto.mappers.toDTO;

import com.bitconex.bitquiz.dto.DoneQuizDTO;
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
        dto.setDateOfFinishing(doneQuiz.getDateOfFinishing());
        dto.setUserIdForSearch(doneQuiz.getUserIdForSearch());
        dto.setQuizIdForSearch(doneQuiz.getQuizIdForSearch());
        dto.setUsername(doneQuiz.getUsername());

        return dto;
    }
}
