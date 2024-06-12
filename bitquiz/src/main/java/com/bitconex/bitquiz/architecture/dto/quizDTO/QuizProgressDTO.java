package com.bitconex.bitquiz.architecture.dto.quizDTO;

import com.bitconex.bitquiz.architecture.request.QuizProgressRequest;
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
}
