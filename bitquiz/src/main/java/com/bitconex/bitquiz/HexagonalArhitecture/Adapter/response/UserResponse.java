package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.UserRequest;
import lombok.Data;

@Data
public class UserResponse {
    private int id;
    private String name;
    private String email;
    private String roles;
    private int level;
    private int points;

    public static UserDTO requestToDto(UserRequest userRequest){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userRequest.getId());
        userDTO.setPoints(userRequest.getPoints());
        userDTO.setRoles(userRequest.getRoles());
        userDTO.setLevel(userRequest.getLevel());
        userDTO.setName(userRequest.getName());
        userDTO.setEmail(userRequest.getEmail());

        return userDTO;
    }

    public static UserResponse dtoToResponse(UserDTO userDTO){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userDTO.getId());
        userResponse.setPoints(userDTO.getPoints());
        userResponse.setRoles(userDTO.getRoles());
        userResponse.setLevel(userDTO.getLevel());
        userResponse.setName(userDTO.getName());
        userResponse.setEmail(userDTO.getEmail());

        return userResponse;
    }
}
