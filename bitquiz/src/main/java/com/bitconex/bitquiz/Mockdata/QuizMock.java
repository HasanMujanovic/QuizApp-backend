package com.bitconex.bitquiz.Mockdata;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;

public class QuizMock {
    public static QuizDTO getMockQuiz(){

        return QuizDTO.builder().category("Grammar").status("Public")
                .difficulty("Easy").name("Commonly Misspelled Words Quiz")
                .likes(0).doneIt(0).time(5).points(60).build();
    }
    public static QuizDTO getMockQuiz2(){

        return QuizDTO.builder().category("History").status("Private")
                .difficulty("Hard").name("Former Names of Current Places Quiz")
                .likes(0).doneIt(0).time(5).points(60).build();
    }
}
