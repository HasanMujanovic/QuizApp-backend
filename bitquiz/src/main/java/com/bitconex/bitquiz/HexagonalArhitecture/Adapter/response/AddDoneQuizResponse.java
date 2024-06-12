package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import lombok.Data;

@Data
public class AddDoneQuizResponse {
    UserDTO user;
    QuizDTO quiz;
    DoneQuizDTO doneQuiz;
}
