package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dto.mappers.toEntity.QuizProgressMapper;
import com.bitconex.bitquiz.repository.QuizProgressRepo;
import com.bitconex.bitquiz.dto.AddQuizProgressDto;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.SaveProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaveProgressServiceImpl implements SaveProgressService {
    private QuizProgressRepo quizProgressRepo;
    private QuizProgressMapper quizProgressMapper;
    private UserRepo userRepo;

    @Autowired
    public SaveProgressServiceImpl(QuizProgressRepo quizProgressRepo, QuizProgressMapper quizProgressMapper,
                                   UserRepo userRepo) {
        this.quizProgressRepo = quizProgressRepo;
        this.quizProgressMapper = quizProgressMapper;
        this.userRepo = userRepo;
    }

    @Override
    public void saveProgress(AddQuizProgressDto addQuizProgressDto) {
        User user = userRepo.findByEmail(addQuizProgressDto.getUser().getEmail());
        QuizProgress quizProgress = quizProgressMapper.apply(addQuizProgressDto.getQuizProgress());

        Optional<QuizProgress> existingProgressOpt = quizProgressRepo.findByUserSavedAndQuizId(user, quizProgress.getQuizId());
        if (existingProgressOpt.isPresent()) {
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
