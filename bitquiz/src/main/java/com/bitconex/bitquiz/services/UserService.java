package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.entity.User;

public interface UserService {
    void saveUser(User user);
    UserDTO getUser(String email);
    boolean checkIfUserExistsSignUp(String email);
    boolean checkIfUserExistsLogIn(String email, String password);
}
