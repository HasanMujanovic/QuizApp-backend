package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.AddQuizProgressRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.AddQuizProgressResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddQuizProgressDto {
    UserDTO user;
    QuizProgressDTO quizProgress;

    public static AddQuizProgressDto requestToDto(AddQuizProgressRequest addQuizProgressRequest){
        AddQuizProgressDto addQuizProgressDto = new AddQuizProgressDto();

        addQuizProgressDto.setQuizProgress(addQuizProgressRequest.getQuizProgress());
        addQuizProgressDto.setUser(addQuizProgressRequest.getUser());

        return addQuizProgressDto;
    }

    public static AddQuizProgressResponse dtoToResponse(AddQuizProgressDto addQuizProgressDto){
        AddQuizProgressResponse addQuizProgressResponse = new AddQuizProgressResponse();

        addQuizProgressResponse.setQuizProgress(addQuizProgressDto.getQuizProgress());
        addQuizProgressResponse.setUser(addQuizProgressDto.getUser());

        return addQuizProgressResponse;
    }
}
