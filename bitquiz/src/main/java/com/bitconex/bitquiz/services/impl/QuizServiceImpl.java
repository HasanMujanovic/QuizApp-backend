package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dao.QuizRepo;
import com.bitconex.bitquiz.dao.UserRepo;
import com.bitconex.bitquiz.dto.MakeQuizDto;
import com.bitconex.bitquiz.entity.*;
import com.bitconex.bitquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    QuizRepo quizRepo;

    @Override
    public void makeQuiz(MakeQuizDto makeQuizDto) {
        com.bitconex.bitquiz.entity.Quiz quiz = makeQuizDto.getQuiz();
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

    @Override
    public void editQuiz(Quiz newQuizServiceData) {
        Optional<Quiz> quizOptional = quizRepo.findById(newQuizServiceData.getId());

        if (quizOptional.isPresent()){
            Quiz existingQuiz = quizOptional.get();
            existingQuiz.setCategory(newQuizServiceData.getCategory());
            existingQuiz.setDifficulty(newQuizServiceData.getDifficulty());
            existingQuiz.setName(newQuizServiceData.getName());
            existingQuiz.setStatus(newQuizServiceData.getStatus());

            quizRepo.save(existingQuiz);
        }

    }
}
