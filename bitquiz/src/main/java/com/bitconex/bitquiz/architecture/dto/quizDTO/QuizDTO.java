package com.bitconex.bitquiz.architecture.dto.quizDTO;

import com.bitconex.bitquiz.architecture.request.QuizRequest;
import com.bitconex.bitquiz.architecture.response.QuizResponse;
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


    public static QuizDTO requestToDto(QuizRequest quizRequest){
        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setId(quizRequest.getId());
        quizDTO.setCategory(quizRequest.getCategory());
        quizDTO.setStatus(quizRequest.getStatus());
        quizDTO.setDifficulty(quizRequest.getDifficulty());
        quizDTO.setName(quizRequest.getName());
        quizDTO.setLikes(quizRequest.getLikes());
        quizDTO.setDoneIt(quizRequest.getDoneIt());
        quizDTO.setTime(quizRequest.getTime());
        quizDTO.setPoints(quizRequest.getPoints());
        return quizDTO;
    }

    public static QuizResponse dtoToResponse(QuizDTO quizDto){
        QuizResponse quizResponse = new QuizResponse();
        quizResponse.setId(quizDto.getId());
        quizResponse.setCategory(quizDto.getCategory());
        quizResponse.setStatus(quizDto.getStatus());
        quizResponse.setDifficulty(quizDto.getDifficulty());
        quizResponse.setName(quizDto.getName());
        quizResponse.setLikes(quizDto.getLikes());
        quizResponse.setDoneIt(quizDto.getDoneIt());
        quizResponse.setTime(quizDto.getTime());
        quizResponse.setPoints(quizDto.getPoints());
        return quizResponse;
    }

}
