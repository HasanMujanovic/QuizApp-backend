package com.bitconex.bitquiz.architecture.dto.quizDTO;

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
