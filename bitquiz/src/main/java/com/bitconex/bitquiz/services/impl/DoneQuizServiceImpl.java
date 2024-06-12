package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddDoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.DoneQuizDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.QuizDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.DoneQuizMapper;
import com.bitconex.bitquiz.entity.DoneQuiz;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.DoneQuizRepo;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.DoneQuizService;
import org.springframework.beans.factory.annotation.Autowired;
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
   private QuizRepo quizRepo;
   private DoneQuizMapper doneQuizMapper;
   private DoneQuizDTOMapper doneQuizDTOMapper;

    @Autowired
    public DoneQuizServiceImpl(DoneQuizRepo doneQuizRepo, UserRepo userRepo,
                               QuizDTOMapper quizDTOMapper, QuizRepo quizRepo,
                               DoneQuizMapper doneQuizMapper, DoneQuizDTOMapper doneQuizDTOMapper) {
        this.doneQuizRepo = doneQuizRepo;
        this.userRepo = userRepo;
        this.quizDTOMapper = quizDTOMapper;
        this.quizRepo = quizRepo;
        this.doneQuizMapper = doneQuizMapper;
        this.doneQuizDTOMapper = doneQuizDTOMapper;
    }

    @Override
    public void addDoneQuiz(AddDoneQuizDTO addDoneQuizDTO) {
        DoneQuizDTO doneQuizDTO = addDoneQuizDTO.getDoneQuiz();

        User user = userRepo.findByEmail(addDoneQuizDTO.getUser().getEmail());
        Quiz quiz = quizRepo.findById(addDoneQuizDTO.getQuiz().getId());
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
        User user = userRepo.findById(userId);
        List<DoneQuiz> doneQuizzes = user.getDoneQuiz();

        return doneQuizzes.stream()
                    .map(doneQuizDTOMapper)
                    .collect(Collectors.toList());
    }


}
