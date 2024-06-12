package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.QuizResponseRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.QuziResponsessResponse;
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

    public static  QuizResponseDTO requestToDto(QuizResponseRequest quizResponseRequest){
        QuizResponseDTO quizResponseDTO = new QuizResponseDTO();
        quizResponseDTO.setId(quizResponseRequest.getId());
        quizResponseDTO.setText(quizResponseRequest.getText());
        quizResponseDTO.setCorrectAnswer(quizResponseRequest.isCorrectAnswer());

        return quizResponseDTO;
    }

    public static QuziResponsessResponse dtoToResponse(QuizResponseDTO quizResponseDto){
        QuziResponsessResponse quziResponsessResponse = new QuziResponsessResponse();
        quziResponsessResponse.setId(quizResponseDto.getId());
        quziResponsessResponse.setText(quizResponseDto.getText());
        quziResponsessResponse.setCorrectAnswer(quizResponseDto.isCorrectAnswer());

        return quziResponsessResponse;
    }
}
