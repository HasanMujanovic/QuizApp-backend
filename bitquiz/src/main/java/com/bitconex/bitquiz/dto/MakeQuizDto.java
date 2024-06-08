package com.bitconex.bitquiz.dto;

import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizQuestions;
import com.bitconex.bitquiz.entity.QuizResponse;
import com.bitconex.bitquiz.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MakeQuizDto {
    User user;
    Quiz quiz;
    List<QuizQuestions> quizQuestions;
    List<QuizResponse[]> quizResponse;
}
