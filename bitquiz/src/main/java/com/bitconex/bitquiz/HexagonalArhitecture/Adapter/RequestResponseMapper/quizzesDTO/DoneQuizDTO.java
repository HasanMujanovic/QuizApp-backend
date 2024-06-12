package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.DoneQuizRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.DoneQuizResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoneQuizDTO {
    private int id;
    private int pointsWon;
    private int timeLeft;
    private int userIdForSearch;
    private int quizIdForSearch;
    private String username;

    public static DoneQuizDTO requestToDto(DoneQuizRequest doneQuizRequest){
        DoneQuizDTO doneQuizDTO = new DoneQuizDTO();

        doneQuizDTO.setId(doneQuizRequest.getId());
        doneQuizDTO.setQuizIdForSearch(doneQuizRequest.getQuizIdForSearch());
        doneQuizDTO.setUsername(doneQuizRequest.getUsername());
        doneQuizDTO.setTimeLeft(doneQuizRequest.getTimeLeft());
        doneQuizDTO.setPointsWon(doneQuizRequest.getPointsWon());
        doneQuizDTO.setUsername(doneQuizRequest.getUsername());

        return doneQuizDTO;
    }

    public static DoneQuizResponse dtoToResponse(DoneQuizDTO doneQuizDTO){
        DoneQuizResponse doneQuizResponse = new DoneQuizResponse();

        doneQuizResponse.setId(doneQuizDTO.getId());
        doneQuizResponse.setQuizIdForSearch(doneQuizDTO.getQuizIdForSearch());
        doneQuizResponse.setUsername(doneQuizDTO.getUsername());
        doneQuizResponse.setTimeLeft(doneQuizDTO.getTimeLeft());
        doneQuizResponse.setPointsWon(doneQuizDTO.getPointsWon());
        doneQuizResponse.setUsername(doneQuizDTO.getUsername());

        return doneQuizResponse;
    }

}
