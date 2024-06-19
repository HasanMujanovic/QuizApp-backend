package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.quizzesRequest.QuizQuestionsRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.quizzesResponse.QuizQuestionsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizQuestionsDTO {
    private long id;
    private String text;
    private int points;
    private boolean helpAllowed;
    private int minusPoints;

    public static QuizQuestionsDTO requestToDto(QuizQuestionsRequest quizQuestionsRequest){
        QuizQuestionsDTO quizQuestionsDTO = new QuizQuestionsDTO();

        quizQuestionsDTO.setId(quizQuestionsRequest.getId());
        quizQuestionsDTO.setPoints(quizQuestionsRequest.getPoints());
        quizQuestionsDTO.setText(quizQuestionsRequest.getText());
        quizQuestionsDTO.setHelpAllowed(quizQuestionsRequest.isHelpAllowed());
        quizQuestionsDTO.setMinusPoints(quizQuestionsRequest.getMinusPoints());

        return quizQuestionsDTO;
    }

    public static QuizQuestionsResponse dtoToResponse(QuizQuestionsDTO quizQuestionsDTO){
        QuizQuestionsResponse quizQuestionsResponse = new QuizQuestionsResponse();

        quizQuestionsResponse.setId(quizQuestionsDTO.getId());
        quizQuestionsResponse.setPoints(quizQuestionsDTO.getPoints());
        quizQuestionsResponse.setText(quizQuestionsDTO.getText());
        quizQuestionsResponse.setHelpAllowed(quizQuestionsDTO.isHelpAllowed());
        quizQuestionsResponse.setMinusPoints(quizQuestionsDTO.getMinusPoints());

        return quizQuestionsResponse;
    }
}
