package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dao.QuizProgressRepo;
import com.bitconex.bitquiz.dto.QuizProgressDto;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.services.SaveProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveProgressServiceImpl implements SaveProgressService {
    @Autowired
    private QuizProgressRepo quizProgressRepo;

    @Override
    public void saveProgress(QuizProgressDto quizProgressDto) {
        Quiz quiz = quizProgressDto.getQuiz();
        User user = quizProgressDto.getUser();
        QuizProgress quizProgress = quizProgressDto.getQuizProgress();

        quiz.addSavedKviz(quizProgress);
        user.addSavedKviz(quizProgress);

        quizProgressRepo.save(quizProgress);

    }
}
