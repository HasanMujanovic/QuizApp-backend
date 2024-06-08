package com.bitconex.bitquiz.dto;

import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizProgressDto {
    Quiz quiz;
    User user;
    QuizProgress quizProgress;


}
