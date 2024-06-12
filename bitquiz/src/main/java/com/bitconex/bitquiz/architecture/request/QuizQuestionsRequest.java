package com.bitconex.bitquiz.architecture.request;

import lombok.Data;

@Data
public class QuizQuestionsRequest {
    private long id;
    private String text;
    private int points;
    private boolean helpAllowed;
    private int minusPoints;
}
