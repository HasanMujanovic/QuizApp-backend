package com.bitconex.bitquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizProgressDTO {
    private int id;
    private int points;
    private int time;
    private int questionsAnswered;
    private Date timeOfSaving;
    private int quizId;
}
