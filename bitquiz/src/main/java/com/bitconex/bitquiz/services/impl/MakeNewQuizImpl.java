package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dao.UserRepo;
import com.bitconex.bitquiz.dto.MakeQuizDto;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizQuestions;
import com.bitconex.bitquiz.entity.QuizResponse;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.services.MakeNewQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MakeNewQuizImpl implements MakeNewQuiz {

    @Autowired
    UserRepo userRepo;

    @Override
    public void makeQuiz(MakeQuizDto makeQuizDto) {
        Quiz quiz = makeQuizDto.getQuiz();
        User user = makeQuizDto.getUser();

        List<QuizQuestions> quizQuestions = new ArrayList<>();
        List<QuizResponse[]> quizResponse = new ArrayList<>();

        quizQuestions = makeQuizDto.getQuizQuestions();
        quizResponse = makeQuizDto.getQuizResponse();

        for (int i = 0; i< quizQuestions.size(); i++){
            quizQuestions.get(i).add(quizResponse.get(i));
        }

        quizQuestions.forEach(quiz::add);

        user.add(quiz);

        userRepo.save(user);

    }
}
