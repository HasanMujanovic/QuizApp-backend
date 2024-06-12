package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response;

import lombok.Data;

@Data
public class QuizProgressResponse {

    private int id;
    private int points;
    private int time;
    private int questionsAnswered;
    private int quizId;
    private int correctAns;
    private int wrongAns;
    private int skippedAns;
}
