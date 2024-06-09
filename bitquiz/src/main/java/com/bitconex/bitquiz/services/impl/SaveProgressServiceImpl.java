package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dao.QuizProgressRepo;
import com.bitconex.bitquiz.dto.QuizProgressDto;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.services.SaveProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaveProgressServiceImpl implements SaveProgressService {
    @Autowired
    private QuizProgressRepo quizProgressRepo;

    @Override
    public void saveProgress(QuizProgressDto quizProgressDto) {
        User user = quizProgressDto.getUser();
        QuizProgress quizProgress = quizProgressDto.getQuizProgress();

        Optional<QuizProgress> existingProgressOpt = quizProgressRepo.findByUserSavedAndQuizId(user,quizProgress.getQuizId());
        if (existingProgressOpt.isPresent()){
            QuizProgress existingProgress = existingProgressOpt.get();

            existingProgress.setTimeOfSaving(quizProgress.getTimeOfSaving());
            existingProgress.setPoints(quizProgress.getPoints());
            existingProgress.setTime(quizProgress.getTime());
            existingProgress.setQuestionsAnswered(quizProgress.getQuestionsAnswered());

            quizProgressRepo.save(existingProgress);
        } else {
            user.addSavedKviz(quizProgress);
            quizProgressRepo.save(quizProgress);
        }
    }



}
