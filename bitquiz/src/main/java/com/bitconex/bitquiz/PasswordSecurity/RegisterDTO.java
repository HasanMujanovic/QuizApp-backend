package com.bitconex.bitquiz.PasswordSecurity;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import lombok.Data;

@Data
public class RegisterDTO {
    UserDTO userDTO;
    String password;
}

