package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request;

import lombok.Data;

@Data
public class QuizProgressRequest {
    private int id;
    private int points;
    private int time;
    private int questionsAnswered;
    private int quizId;
    private int correctAns;
    private int wrongAns;
    private int skippedAns;
}
