package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class MakeQuizResponse {
    UserDTO user;
    QuizDTO quiz;
    List<QuizQuestionsDTO> quizQuestions;
    List<QuizResponseDTO[]> quizResponse;
}
