package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import lombok.Data;

@Data
public class AddDoneQuizRequest {
    UserDTO user;
    QuizDTO quiz;
    DoneQuizDTO doneQuiz;
}
