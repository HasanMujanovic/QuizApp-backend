package com.bitconex.bitquiz.architecture.request;

import lombok.Data;

@Data
public class QuizResponseRequest {
    private long id;
    private String text;
    private boolean correctAnswer;
}
