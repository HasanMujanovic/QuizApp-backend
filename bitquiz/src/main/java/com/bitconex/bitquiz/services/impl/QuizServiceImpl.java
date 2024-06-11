package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dto.MakeQuizDto;
import com.bitconex.bitquiz.dto.QuizDTO;
import com.bitconex.bitquiz.dto.mappers.toDTO.QuizDTOMapper;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizQuestions;
import com.bitconex.bitquiz.entity.QuizResponse;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class QuizServiceImpl implements QuizService {

   private UserRepo userRepo;
   private QuizRepo quizRepo;
   private QuizDTOMapper quizDTOMapper;

   @Autowired
    public QuizServiceImpl(UserRepo userRepo, QuizRepo quizRepo, QuizDTOMapper quizDTOMapper) {
        this.userRepo = userRepo;
        this.quizRepo = quizRepo;
        this.quizDTOMapper = quizDTOMapper;
    }

    @Override
    public void makeQuiz(MakeQuizDto makeQuizDto) {
        com.bitconex.bitquiz.entity.Quiz quiz = makeQuizDto.getQuiz();
        User user = makeQuizDto.getUser();

        List<QuizQuestions> quizQuestions = new ArrayList<>();
        List<QuizResponse[]> quizResponse = new ArrayList<>();

        quizQuestions = makeQuizDto.getQuizQuestions();
        quizResponse = makeQuizDto.getQuizResponse();

        for (int i = 0; i< quizQuestions.size(); i++){
            quizQuestions.get(i).add(quizResponse.get(i));
        }

        quizQuestions.forEach(quiz::add);

        user.add(quiz);

        userRepo.save(user);

    }

    @Override
    public void editQuiz(Quiz newQuizServiceData) {
        Optional<Quiz> quizOptional = quizRepo.findById(newQuizServiceData.getId());

        if (quizOptional.isPresent()){
            Quiz existingQuiz = quizOptional.get();
            existingQuiz.setCategory(newQuizServiceData.getCategory());
            existingQuiz.setDifficulty(newQuizServiceData.getDifficulty());
            existingQuiz.setName(newQuizServiceData.getName());
            existingQuiz.setStatus(newQuizServiceData.getStatus());

            quizRepo.save(existingQuiz);
        }
    }

    @Override
    public List<QuizDTO> getAllQuiz() {
        List<Quiz> quizList = quizRepo.findAll();
        return quizList.stream()
                .map(quiz -> quizDTOMapper.apply(quiz))
                .collect(Collectors.toList());
   }

    @Override
    public QuizDTO getOneQuiz(int quizId) {
        Optional<Quiz> quizOptional = quizRepo.findById(quizId);
        Quiz existingQuiz = new Quiz();
        if (quizOptional.isPresent()){
            existingQuiz = quizOptional.get();
        }
        return quizDTOMapper.apply(existingQuiz);
    }

}
