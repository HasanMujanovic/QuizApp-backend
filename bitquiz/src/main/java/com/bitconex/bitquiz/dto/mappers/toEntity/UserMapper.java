package com.bitconex.bitquiz.dto.mappers.toEntity;

import com.bitconex.bitquiz.dto.UserDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.DoneQuizRepo;
import com.bitconex.bitquiz.repository.QuizProgressRepo;
import com.bitconex.bitquiz.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.Optional;

@Service
public class UserMapper implements Function<UserDTO, User> {
    private QuizRepo quizRepo;
    private DoneQuizRepo doneQuizRepo;
    private QuizProgressRepo quizProgressRepo;

    @Autowired
    public UserMapper(QuizRepo quizRepo, DoneQuizRepo doneQuizRepo, QuizProgressRepo quizProgressRepo) {
        this.quizRepo = quizRepo;
        this.doneQuizRepo = doneQuizRepo;
        this.quizProgressRepo = quizProgressRepo;
    }

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
