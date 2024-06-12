package com.bitconex.bitquiz.architecture.dto;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizDTO;
import com.bitconex.bitquiz.architecture.dto.userDTO.UserDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.DoneQuizDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDoneQuizDTO {
    UserDTO user;
    QuizDTO quiz;
    DoneQuizDTO doneQuiz;
}
