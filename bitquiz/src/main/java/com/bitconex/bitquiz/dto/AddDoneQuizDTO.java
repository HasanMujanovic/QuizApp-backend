package com.bitconex.bitquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDoneQuizDTO {
    UserDTO user;
    QuizDTO quiz;
    DoneQuizDTO doneQuiz;
}
