package com.bitconex.bitquiz.architecture.dto;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizProgressDTO;
import com.bitconex.bitquiz.architecture.dto.userDTO.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddQuizProgressDto {
    UserDTO user;
    QuizProgressDTO quizProgress;
}
