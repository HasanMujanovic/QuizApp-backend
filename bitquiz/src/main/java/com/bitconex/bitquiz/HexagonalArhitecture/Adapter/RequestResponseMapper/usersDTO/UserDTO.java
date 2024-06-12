package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.usersRequest.UserRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.userResponse.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String roles;
    private int level;
    private int points;

    public static UserDTO requestToDto(UserRequest userRequest){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userRequest.getId());
        userDTO.setName(userRequest.getName());
        userDTO.setEmail(userRequest.getEmail());
        userDTO.setRoles(userRequest.getRoles());
        userDTO.setLevel(userRequest.getLevel());
        userDTO.setPoints(userRequest.getPoints());

        return userDTO;
    }

    public static UserResponse dtoToResponse(UserDTO userDTO){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userDTO.getId());
        userResponse.setName(userDTO.getName());
        userResponse.setEmail(userDTO.getEmail());
        userResponse.setRoles(userDTO.getRoles());
        userResponse.setLevel(userDTO.getLevel());
        userResponse.setPoints(userDTO.getPoints());

        return userResponse;
    }
}
