package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.PasswordSecurity.CredentialsDTO;
import com.bitconex.bitquiz.PasswordSecurity.RegisterDTO;

import java.util.List;

public interface UserService {
    UserDTO getUser(String email);
    UserDTO getUserById(int userId);
    void saveUserStatus(String status, String email);
    List<UserDTO> getTop5UsersSortedByLevelAndPoints();
    UserDTO loginAuth(CredentialsDTO credentialsDTO);
    UserDTO register(RegisterDTO registerDTO);
}
