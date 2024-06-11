package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.repository.DoneQuizRepo;
import com.bitconex.bitquiz.dto.AddDoneQuizDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.services.DoneQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoneQuizServiceImpl implements DoneQuizService {

    @Autowired
    DoneQuizRepo doneQuizRepo;

    @Override
    public void addDoneQuiz(AddDoneQuizDTO addDoneQuizDTO) {

        User user = addDoneQuizDTO.getUser();
        Quiz quiz = addDoneQuizDTO.getQuiz();
        DoneQuiz doneQuiz = addDoneQuizDTO.getDoneQuiz();
        user.addZavrsenKviz(doneQuiz);
        quiz.addZavrsenKviz(doneQuiz);
        doneQuizRepo.save(doneQuiz);
    }

    @Override
    public List<DoneQuiz> getSortedLeaderboard(int quizId, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return doneQuizRepo.findByQuizEndIdOrderByPointsWonDescTimeLeftDesc(quizId, pageable).getContent();
    }
}
