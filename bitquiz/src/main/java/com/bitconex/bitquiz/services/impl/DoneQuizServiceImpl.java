package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.ErrorMessage.AppException;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddDoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.DoneQuizDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.DoneQuizMapper;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.DoneQuizRepo;
import com.bitconex.bitquiz.repository.QuizProgressRepo;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.DoneQuizService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoneQuizServiceImpl implements DoneQuizService {

   private DoneQuizRepo doneQuizRepo;
   private UserRepo userRepo;
   private QuizProgressRepo quizProgressRepo;
   private QuizRepo quizRepo;
   private DoneQuizMapper doneQuizMapper;
   private DoneQuizDTOMapper doneQuizDTOMapper;

    @Autowired
    public DoneQuizServiceImpl(DoneQuizRepo doneQuizRepo, UserRepo userRepo,
                               QuizProgressRepo quizProgressRepo, QuizRepo quizRepo,
                               DoneQuizMapper doneQuizMapper, DoneQuizDTOMapper doneQuizDTOMapper) {
        this.doneQuizRepo = doneQuizRepo;
        this.userRepo = userRepo;
        this.quizProgressRepo = quizProgressRepo;
        this.quizRepo = quizRepo;
        this.doneQuizMapper = doneQuizMapper;
        this.doneQuizDTOMapper = doneQuizDTOMapper;
    }

    @Transactional
    @Override
    public void addDoneQuiz(AddDoneQuizDTO addDoneQuizDTO) {
        DoneQuizDTO doneQuizDTO = addDoneQuizDTO.getDoneQuiz();

        Optional<User> userOptional = userRepo.findByEmail(addDoneQuizDTO.getUser().getEmail());
        User user = new User();

        if (userOptional.isPresent()){
            user = userOptional.get();
        } else {
            throw new AppException("Cannot find user", HttpStatus.BAD_REQUEST);
        }

        Optional<Quiz> quizOptional = quizRepo.findById(addDoneQuizDTO.getQuiz().getId());
        Quiz quiz = new Quiz();
        List<QuizProgress> quizProgressList = user.getQuizProgresses();

        if (quizOptional.isPresent()){
            quiz = quizOptional.get();
        } else {
            throw new AppException("Cannot find Quiz", HttpStatus.BAD_REQUEST);
        }
        for (QuizProgress quizProgress : quizProgressList) {
            if (quizProgress.getQuizId() == quiz.getId()) {
                user.removeQuizProgress(quizProgress);
                break;
            }
        }

        user.setPoints(user.getPoints() + quiz.getPoints());
        quiz.setDoneIt(quiz.getDoneIt() + 1);

        DoneQuiz doneQuiz = doneQuizMapper.apply(doneQuizDTO);

        user.addZavrsenKviz(doneQuiz);
        quiz.addZavrsenKviz(doneQuiz);
        doneQuizRepo.save(doneQuiz);
    }

    @Override
    public List<DoneQuizDTO> getSortedLeaderboard(int quizId, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        List<DoneQuiz> doneQuizList = doneQuizRepo.findByQuizEndIdOrderByPointsWonDescTimeLeftDesc(quizId, pageable).getContent();
        return doneQuizList.stream()
                .map(res -> doneQuizDTOMapper.apply(res))
                .collect(Collectors.toList());
    }

    @Override
    public List<DoneQuizDTO> getDoneQuizzesByUserId(int userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        User user = new User();

        if (userOptional.isPresent()){
            user = userOptional.get();
        } else {
            throw new AppException("Cannot find user", HttpStatus.BAD_REQUEST);
        }
        List<DoneQuiz> doneQuizzes = user.getDoneQuiz();

        return doneQuizzes.stream()
                    .map(doneQuizDTOMapper)
                    .collect(Collectors.toList());
    }


}
