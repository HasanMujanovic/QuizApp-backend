package com.bitconex.bitquiz.Mockdata;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;

import java.util.List;

public class QuizQuestionsMock {

    public static List<QuizQuestionsDTO> getQuizQuestions() {

        QuizQuestionsDTO quizQuestions1 = QuizQuestionsDTO.builder()
                .text("Rachel seemed to be _____ in every endeavor she started.")
                .points(20).helpAllowed(true).minusPoints(5)
                .build();

        QuizQuestionsDTO quizQuestions2 = QuizQuestionsDTO.builder()
                .text("The new recruit was expected to _____ many milestones in her first year.")
                .points(20).helpAllowed(true).minusPoints(5)
                .build();

        QuizQuestionsDTO quizQuestions3 = QuizQuestionsDTO.builder()
                .text("Rose had a detailed _____ for her trip to Greece.")
                .points(20).helpAllowed(false).minusPoints(5)
                .build();

        return List.of(quizQuestions1, quizQuestions2, quizQuestions3);
    }
    public static List<QuizQuestionsDTO> getQuziQuestions2(){

        QuizQuestionsDTO quizQuestions4 = QuizQuestionsDTO.builder()
                .text("Which of these places was once called New Amsterdam?")
                .points(20).helpAllowed(true).minusPoints(5)
                .build();

        QuizQuestionsDTO quizQuestions5 = QuizQuestionsDTO.builder()
                .text("Constantinople is also known as?")
                .points(20).helpAllowed(false).minusPoints(5)
                .build();

        QuizQuestionsDTO quizQuestions6 = QuizQuestionsDTO.builder()
                .text("Which of these places was once called Peking?")
                .points(20).helpAllowed(false).minusPoints(5)
                .build();

        return List.of(quizQuestions4, quizQuestions5, quizQuestions6);
    }
}
