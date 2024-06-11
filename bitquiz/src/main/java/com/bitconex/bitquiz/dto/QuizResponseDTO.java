package com.bitconex.bitquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizResponseDTO {
    private long id;
    private String text;
    private boolean correctAnswer;
}