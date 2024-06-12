package com.bitconex.bitquiz.architecture.dto.mappers.toDTO;

import com.bitconex.bitquiz.architecture.dto.userDTO.UserDTO;
import com.bitconex.bitquiz.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles());
        dto.setLevel(user.getLevel());
        dto.setPoints(user.getPoints());

        return dto;    }
}
