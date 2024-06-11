package com.bitconex.bitquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String roles;
    private int level;
    private int points;
    private List<Integer> quizzes;
    private List<Integer> doneQuiz;
    private List<Integer> quizProgresses;

}
