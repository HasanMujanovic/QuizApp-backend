package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.quizzesRequest;

import lombok.Data;

@Data
public class QuizResponseRequest {
    private long id;
    private String text;
    private boolean correctAnswer;
}
