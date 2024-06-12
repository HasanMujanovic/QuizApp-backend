package com.bitconex.bitquiz.architecture.dto;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizResponseDTO;
import com.bitconex.bitquiz.architecture.dto.userDTO.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MakeQuizDto {
    UserDTO user;
    QuizDTO quiz;
    List<QuizQuestionsDTO> quizQuestions;
    List<QuizResponseDTO[]> quizResponse;
}
