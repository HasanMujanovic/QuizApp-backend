package com.bitconex.bitquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizQuestionsDTO {
    private long id;
    private String text;
    private int points;
    private boolean helpAllowed;
}
