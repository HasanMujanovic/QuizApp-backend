package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.usersRequest.UserLoginRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.userResponse.UserLoginResponse;
import lombok.Data;

@Data
public class UserLoginDTO {
    String email;
    String Password;

    public static UserLoginDTO requestToResponse(UserLoginRequest userLoginRequest){
        UserLoginDTO userLoginDTO = new UserLoginDTO();

        userLoginDTO.setEmail(userLoginRequest.getEmail());
        userLoginDTO.setPassword(userLoginRequest.getPassword());

        return userLoginDTO;
    }

    public static UserLoginResponse dtoToResponse(UserLoginDTO userLoginDTO){
        UserLoginResponse userLoginResponse = new UserLoginResponse();

        userLoginResponse.setEmail(userLoginDTO.getEmail());
        userLoginResponse.setPassword(userLoginDTO.getPassword());

        return userLoginResponse;
    }
}
