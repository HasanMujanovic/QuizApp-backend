package com.bitconex.bitquiz.dto.mappers.toDTO;

import com.bitconex.bitquiz.dto.UserDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

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
