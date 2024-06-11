package com.bitconex.bitquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoneQuizDTO {
    private int id;
    private int pointsWon;
    private int timeLeft;
    private Date dateOfFinishing;
    private int userIdForSearch;
    private int quizIdForSearch;
    private String username;

}
