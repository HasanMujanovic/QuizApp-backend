package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.QuizProgressRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.QuizProgressResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizProgressDTO {
    private int id;
    private int points;
    private int time;
    private int questionsAnswered;
    private int quizId;
    private int correctAns;
    private int wrongAns;
    private int skippedAns;

    public static QuizProgressDTO requestToDto(QuizProgressRequest quizProgressRequest){
        QuizProgressDTO quizProgressDTO = new QuizProgressDTO();
        quizProgressDTO.setQuizId(quizProgressRequest.getQuizId());
        quizProgressDTO.setId(quizProgressRequest.getId());
        quizProgressDTO.setPoints(quizProgressRequest.getPoints());
        quizProgressDTO.setTime(quizProgressRequest.getTime());
        quizProgressDTO.setQuestionsAnswered(quizProgressRequest.getQuestionsAnswered());
        quizProgressDTO.setCorrectAns(quizProgressRequest.getCorrectAns());
        quizProgressDTO.setWrongAns(quizProgressRequest.getWrongAns());
        quizProgressDTO.setSkippedAns(quizProgressRequest.getSkippedAns());
        return quizProgressDTO;
    }

    public static QuizProgressResponse dtoToResponse(QuizProgressDTO quizProgressDTO){
        QuizProgressResponse quizProgressResponse = new QuizProgressResponse();
        quizProgressResponse.setQuizId(quizProgressDTO.getQuizId());
        quizProgressResponse.setId(quizProgressDTO.getId());
        quizProgressResponse.setPoints(quizProgressDTO.getPoints());
        quizProgressResponse.setTime(quizProgressDTO.getTime());
        quizProgressResponse.setQuestionsAnswered(quizProgressDTO.getQuestionsAnswered());
        quizProgressResponse.setCorrectAns(quizProgressDTO.getCorrectAns());
        quizProgressResponse.setWrongAns(quizProgressDTO.getWrongAns());
        quizProgressResponse.setSkippedAns(quizProgressDTO.getSkippedAns());
        return quizProgressResponse;
    }
}
