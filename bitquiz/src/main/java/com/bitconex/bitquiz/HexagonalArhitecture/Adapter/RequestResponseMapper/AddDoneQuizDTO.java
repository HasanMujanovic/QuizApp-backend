package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.AddDoneQuizRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.AddDoneQuizResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDoneQuizDTO {
    UserDTO user;
    QuizDTO quiz;
    DoneQuizDTO doneQuiz;

    public static AddDoneQuizDTO requestToDto(AddDoneQuizRequest addDoneQuizRequest){
        AddDoneQuizDTO addDoneQuizDTO = new AddDoneQuizDTO();

        addDoneQuizDTO.setUser(addDoneQuizRequest.getUser());
        addDoneQuizDTO.setDoneQuiz(addDoneQuizRequest.getDoneQuiz());
        addDoneQuizDTO.setQuiz(addDoneQuizRequest.getQuiz());

        return addDoneQuizDTO;
    }

    public static AddDoneQuizResponse dtoToResponse (AddDoneQuizDTO addDoneQuizDTO){
        AddDoneQuizResponse addDoneQuizResponse = new AddDoneQuizResponse();

        addDoneQuizResponse.setUser(addDoneQuizDTO.getUser());
        addDoneQuizResponse.setDoneQuiz(addDoneQuizDTO.getDoneQuiz());
        addDoneQuizResponse.setQuiz(addDoneQuizDTO.getQuiz());

        return addDoneQuizResponse;
    }
}
