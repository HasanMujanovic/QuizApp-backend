package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dto.AddDoneQuizDTO;
import com.bitconex.bitquiz.dto.QuizDTO;
import com.bitconex.bitquiz.dto.mappers.toDTO.QuizDTOMapper;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.DoneQuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.DoneQuizService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoneQuizServiceImpl implements DoneQuizService {

   private DoneQuizRepo doneQuizRepo;
   private UserRepo userRepo;
   private QuizDTOMapper quizDTOMapper;

    public DoneQuizServiceImpl(DoneQuizRepo doneQuizRepo, UserRepo userRepo,
                               QuizDTOMapper quizDTOMapper) {
        this.doneQuizRepo = doneQuizRepo;
        this.userRepo = userRepo;
        this.quizDTOMapper = quizDTOMapper;
    }

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

    @Override
    public List<QuizDTO> getQuizesMadeByUser(int userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        List<Quiz> quizzes = user.getQuizzes();

        return quizzes.stream()
                .map(quizDTOMapper::apply)
                .collect(Collectors.toList());
    }
}
