package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddDoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;

import java.util.List;

public interface DoneQuizService {
    void addDoneQuiz(AddDoneQuizDTO addDoneQuizDTO);
    List<DoneQuizDTO> getSortedLeaderboard(int quizId, int limit);
    List<DoneQuizDTO> getDoneQuizzesByUserId(int userId);
}
