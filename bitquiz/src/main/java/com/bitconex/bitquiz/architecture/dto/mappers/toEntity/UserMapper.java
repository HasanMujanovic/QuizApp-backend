package com.bitconex.bitquiz.architecture.dto.mappers.toEntity;

import com.bitconex.bitquiz.architecture.dto.userDTO.UserDTO;
import com.bitconex.bitquiz.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserMapper implements Function<UserDTO, User> {
    @Override
    public User apply(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRoles(userDTO.getRoles());
        user.setLevel(userDTO.getLevel());
        user.setPoints(userDTO.getPoints());




        return user;    }
}
