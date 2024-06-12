package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.architecture.dto.AddDoneQuizDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.DoneQuizDTO;

import java.util.List;

public interface DoneQuizService {
    void addDoneQuiz(AddDoneQuizDTO addDoneQuizDTO);
    List<DoneQuizDTO> getSortedLeaderboard(int quizId, int limit);
    List<DoneQuizDTO> getDoneQuizzesByUserId(int userId);
}
