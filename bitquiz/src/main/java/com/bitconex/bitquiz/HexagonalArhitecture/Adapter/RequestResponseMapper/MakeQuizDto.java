package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.MakeQuizRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.MakeQuizResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MakeQuizDto {
    UserDTO user;
    QuizDTO quiz;
    List<QuizQuestionsDTO> quizQuestions;
    List<QuizResponseDTO[]> quizResponse;

    public static MakeQuizDto requestToDto(MakeQuizRequest makeQuizRequest){
        MakeQuizDto makeQuizDto = new MakeQuizDto();

        makeQuizDto.setUser(makeQuizRequest.getUser());
        makeQuizDto.setQuiz(makeQuizRequest.getQuiz());
        makeQuizDto.setQuizQuestions(makeQuizRequest.getQuizQuestions());
        makeQuizDto.setQuizResponse(makeQuizRequest.getQuizResponse());

        return makeQuizDto;
    }

    public static MakeQuizResponse dtoToRequest(MakeQuizDto makeQuizDto){
        MakeQuizResponse makeQuizResponse = new MakeQuizResponse();

        makeQuizResponse.setUser(makeQuizDto.getUser());
        makeQuizResponse.setQuiz(makeQuizDto.getQuiz());
        makeQuizResponse.setQuizQuestions(makeQuizDto.getQuizQuestions());
        makeQuizResponse.setQuizResponse(makeQuizDto.getQuizResponse());

        return makeQuizResponse;
    }
}
