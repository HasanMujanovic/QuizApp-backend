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

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.Optional;


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


        List<Quiz> quizzes = userDTO.getQuizzes().stream()
                .map(quizRepo::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        user.setQuizzes(quizzes);

        List<DoneQuiz> doneQuizList = userDTO.getDoneQuiz().stream()
                .map(doneQuizRepo::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        user.setDoneQuiz(doneQuizList);

        List<QuizProgress> quizProgressList = userDTO.getQuizProgresses().stream()
                .map(quizProgressRepo::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        user.setQuizProgresses(quizProgressList);

        return user;    }
}
