package com.bitconex.bitquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizDTO {
    private int id;
    private String category;
    private String status;
    private String difficulty;
    private String name;
    private int likes;
    private int doneIt;
    private int time;
    private int points;
//    private List<Long> questions;
//    private List<Integer> doneQuiz;

}
