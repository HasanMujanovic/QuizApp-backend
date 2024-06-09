package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dto.QuizProgressDto;
import com.bitconex.bitquiz.entity.Quiz;

public interface SaveProgressService {
    void saveProgress(QuizProgressDto quizProgressDto);

}
