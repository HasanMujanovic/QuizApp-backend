package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dto.DoneQuizDto;
import com.bitconex.bitquiz.entity.DoneQuiz;

import java.util.List;

public interface DoneQuizService {
    void addDoneQuiz(DoneQuizDto doneQuizDto);
    List<DoneQuiz> getSortedLeaderboard(int quizId, int limit);
}
