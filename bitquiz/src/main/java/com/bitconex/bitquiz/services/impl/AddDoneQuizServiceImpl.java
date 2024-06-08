package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dao.DoneQuizRepo;
import com.bitconex.bitquiz.dto.DoneQuizDto;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.services.AddDoneQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDoneQuizServiceImpl implements AddDoneQuizService {

    @Autowired
    DoneQuizRepo doneQuizRepo;

    @Override
    public void addDoneQuiz(DoneQuizDto doneQuizDto) {

        User user = doneQuizDto.getUser();
        Quiz quiz = doneQuizDto.getQuiz();
        DoneQuiz doneQuiz = doneQuizDto.getDoneQuiz();
        user.addZavrsenKviz(doneQuiz);
        quiz.addZavrsenKviz(doneQuiz);
        doneQuizRepo.save(doneQuiz);
    }
}
