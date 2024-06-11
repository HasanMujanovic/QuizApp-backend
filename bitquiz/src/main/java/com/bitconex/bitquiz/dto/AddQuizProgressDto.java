package com.bitconex.bitquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddQuizProgressDto {
    UserDTO user;
    QuizProgressDTO quizProgress;
}
