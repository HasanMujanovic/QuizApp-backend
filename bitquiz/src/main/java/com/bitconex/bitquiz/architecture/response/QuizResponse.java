package com.bitconex.bitquiz.architecture.response;

import lombok.Data;

@Data
public class QuizResponse {
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
