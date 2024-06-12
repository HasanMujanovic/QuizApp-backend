package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request;

import lombok.Data;

@Data
public class QuizRequest {
    private int id;
    private String category;
    private String status;
    private String difficulty;
    private String name;
    private int likes;
    private int doneIt;
    private int time;
    private int points;
}
