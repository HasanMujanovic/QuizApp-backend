package com.bitconex.bitquiz.Mockdata;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;

import java.util.List;

public class QuizResponsesMock {
    public static List<QuizResponseDTO[]> getResponses(){
        QuizResponseDTO quizResponse1_1 = QuizResponseDTO.builder()
                .text("successfull").correctAnswer(false).build();
        QuizResponseDTO quizResponse1_2 = QuizResponseDTO.builder()
                .text("successful").correctAnswer(true).build();
        QuizResponseDTO quizResponse1_3 = QuizResponseDTO.builder()
                .text("sucessful").correctAnswer(false).build();
        QuizResponseDTO quizResponse1_4 = QuizResponseDTO.builder()
                .text("succesful").correctAnswer(false).build();
        QuizResponseDTO[] quizResponseDTOS = new QuizResponseDTO[]{
                quizResponse1_1,quizResponse1_2,quizResponse1_3,quizResponse1_4
        };

        QuizResponseDTO quizResponse2_1 = QuizResponseDTO.builder()
                .text("achieve").correctAnswer(true).build();
        QuizResponseDTO quizResponse2_2 = QuizResponseDTO.builder()
                .text("acheeve").correctAnswer(false).build();
        QuizResponseDTO quizResponse2_3 = QuizResponseDTO.builder()
                .text("acheive").correctAnswer(false).build();
        QuizResponseDTO quizResponse2_4 = QuizResponseDTO.builder()
                .text("achive").correctAnswer(false).build();
        QuizResponseDTO[] quizResponseDTOS2 = new QuizResponseDTO[]{
                quizResponse2_1,quizResponse2_2,quizResponse2_3,quizResponse2_4
        };

        QuizResponseDTO quizResponse3_1 = QuizResponseDTO.builder()
                .text("itinerary").correctAnswer(true).build();
        QuizResponseDTO quizResponse3_2 = QuizResponseDTO.builder()
                .text("itinarery").correctAnswer(false).build();
        QuizResponseDTO[] quizResponseDTOS3 = new QuizResponseDTO[]{
                quizResponse3_1,quizResponse3_2
        };

        return List.of(quizResponseDTOS, quizResponseDTOS2, quizResponseDTOS3);
    }

    public static List<QuizResponseDTO[]> getResponses2(){

        QuizResponseDTO quizResponse4_1 = QuizResponseDTO.builder()
                .text("London").correctAnswer(false).build();
        QuizResponseDTO quizResponse4_2 = QuizResponseDTO.builder()
                .text("New York City").correctAnswer(true).build();
        QuizResponseDTO quizResponse4_3 = QuizResponseDTO.builder()
                .text("San Francisco").correctAnswer(false).build();
        QuizResponseDTO quizResponse4_4 = QuizResponseDTO.builder()
                .text("Jakarta").correctAnswer(false).build();
        QuizResponseDTO[] quizResponseDTOS4 = new QuizResponseDTO[]{
                quizResponse4_1,quizResponse4_2,quizResponse4_3,quizResponse4_4
        };

        QuizResponseDTO quizResponse5_1 = QuizResponseDTO.builder()
                .text("Istanbul").correctAnswer(true).build();
        QuizResponseDTO quizResponse5_2 = QuizResponseDTO.builder()
                .text("Cairo").correctAnswer(false).build();
        QuizResponseDTO quizResponse5_3 = QuizResponseDTO.builder()
                .text("Athens").correctAnswer(false).build();
        QuizResponseDTO quizResponse5_4 = QuizResponseDTO.builder()
                .text("Tsarigrad").correctAnswer(true).build();
        QuizResponseDTO[] quizResponseDTOS5 = new QuizResponseDTO[]{
                quizResponse5_1,quizResponse5_2,quizResponse5_3,quizResponse5_4
        };

        QuizResponseDTO quizResponse6_1 = QuizResponseDTO.builder()
                .text("Hong Kong").correctAnswer(false).build();
        QuizResponseDTO quizResponse6_2 = QuizResponseDTO.builder()
                .text("Beijing").correctAnswer(true).build();
        QuizResponseDTO[] quizResponseDTOS6 = new QuizResponseDTO[]{
                quizResponse6_1,quizResponse6_2
        };

        return List.of(quizResponseDTOS4, quizResponseDTOS5, quizResponseDTOS6);
    }
}
