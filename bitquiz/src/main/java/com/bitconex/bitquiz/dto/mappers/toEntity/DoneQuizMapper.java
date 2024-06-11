package com.bitconex.bitquiz.dto.mappers.toEntity;

import com.bitconex.bitquiz.dto.DoneQuizDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DoneQuizMapper implements Function<DoneQuizDTO, DoneQuiz> {
    private UserRepo userRepo;
    private QuizRepo quizRepol;

    @Autowired
    public DoneQuizMapper(UserRepo userRepo, QuizRepo quizRepol) {
        this.userRepo = userRepo;
        this.quizRepol = quizRepol;
    }

    @Override
    public DoneQuiz apply(DoneQuizDTO doneQuizDTO) {
        DoneQuiz doneQuiz = new DoneQuiz();
        doneQuiz.setId(doneQuizDTO.getId());
        doneQuiz.setPointsWon(doneQuizDTO.getPointsWon());
        doneQuiz.setTimeLeft(doneQuizDTO.getTimeLeft());
        doneQuiz.setDateOfFinishing(doneQuizDTO.getDateOfFinishing());
        doneQuiz.setUserIdForSearch(doneQuizDTO.getUserIdForSearch());
        doneQuiz.setQuizIdForSearch(doneQuizDTO.getQuizIdForSearch());
        doneQuiz.setUsername(doneQuizDTO.getUsername());

        User user = userRepo.findById(doneQuizDTO.getUserIdForSearch()).orElse(null);
        doneQuiz.setUserEnd(user);

        Quiz quiz = quizRepol.findById(doneQuizDTO.getQuizIdForSearch()).orElse(null);
        doneQuiz.setQuizEnd(quiz);

        return doneQuiz;
    }
}
