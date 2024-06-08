package com.bitconex.bitquiz.dto;

import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoneQuizDto {
    User user;
    Quiz quiz;
    DoneQuiz doneQuiz;
}
