package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dto.AddDoneQuizDTO;
import com.bitconex.bitquiz.dto.QuizDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;

import java.util.List;

public interface DoneQuizService {
    void addDoneQuiz(AddDoneQuizDTO addDoneQuizDTO);
    List<DoneQuiz> getSortedLeaderboard(int quizId, int limit);
    List<QuizDTO>getQuizesMadeByUser(int userId);
}
