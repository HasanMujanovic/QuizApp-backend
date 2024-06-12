package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import lombok.Data;

@Data
public class AddQuizProgressRequest {
    UserDTO user;
    QuizProgressDTO quizProgress;
}
