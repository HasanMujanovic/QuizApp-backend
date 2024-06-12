package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response;

import lombok.Data;

@Data
public class QuizQuestionsResponse {

    private long id;
    private String text;
    private int points;
    private boolean helpAllowed;
    private int minusPoints;
}
