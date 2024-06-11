package com.bitconex.bitquiz.dto;

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
