package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import lombok.Data;

@Data
public class AddQuizProgressResponse {
    UserDTO user;
    QuizProgressDTO quizProgress;
}
