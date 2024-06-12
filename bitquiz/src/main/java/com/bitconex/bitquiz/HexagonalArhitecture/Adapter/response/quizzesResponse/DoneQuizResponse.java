package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.quizzesResponse;

import lombok.Data;

import java.util.Date;

@Data
public class DoneQuizResponse {

    private int id;
    private int pointsWon;
    private int timeLeft;
    private Date dateOfFinishing;
    private int userIdForSearch;
    private int quizIdForSearch;
    private String username;
}
