package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.architecture.dto.MakeQuizDto;
import com.bitconex.bitquiz.architecture.dto.mappers.toDTO.QuizDTOMapper;
import com.bitconex.bitquiz.architecture.dto.mappers.toEntity.QuizMapper;
import com.bitconex.bitquiz.architecture.dto.mappers.toEntity.QuizQuestionsMapper;
import com.bitconex.bitquiz.architecture.dto.mappers.toEntity.QuizResponseMapper;
import com.bitconex.bitquiz.architecture.dto.mappers.toEntity.UserMapper;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizResponseDTO;
import com.bitconex.bitquiz.architecture.dto.userDTO.UserDTO;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.entity.QuizQuestions;
import com.bitconex.bitquiz.entity.QuizResponse;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuizServiceImpl implements QuizService {

   private UserRepo userRepo;
   private QuizRepo quizRepo;
   private QuizDTOMapper quizDTOMapper;
   private QuizMapper quizMapper;
   private UserMapper userMapper;
   private QuizQuestionsMapper quizQuestionsMapper;
   private QuizResponseMapper quizResponseMapper;

    @Autowired
    public QuizServiceImpl(UserRepo userRepo, QuizRepo quizRepo, QuizDTOMapper quizDTOMapper,
                           QuizMapper quizMapper, UserMapper userMapper,
                           QuizQuestionsMapper quizQuestionsMapper, QuizResponseMapper quizResponseMapper) {
        this.userRepo = userRepo;
        this.quizRepo = quizRepo;
        this.quizDTOMapper = quizDTOMapper;
        this.quizMapper = quizMapper;
        this.userMapper = userMapper;
        this.quizQuestionsMapper = quizQuestionsMapper;
        this.quizResponseMapper = quizResponseMapper;
    }

    @Override
    public void makeQuiz(MakeQuizDto makeQuizDto) {
        QuizDTO quizDto = makeQuizDto.getQuiz();
        UserDTO userDto = makeQuizDto.getUser();

        Quiz quiz = quizMapper.apply(quizDto);
        User user = userRepo.findByEmail(userDto.getEmail());

        List<QuizQuestionsDTO> quizQuestionsDtoList = makeQuizDto.getQuizQuestions();
        List<QuizResponseDTO[]> quizResponseDtoList = makeQuizDto.getQuizResponse();

        List<QuizQuestions> quizQuestions = quizQuestionsDtoList.stream()
                .map(quizQuestionsMapper)
                .toList();

        List<QuizResponse[]> quizResponses = quizResponseDtoList.stream()
                .map(array -> Arrays.stream(array)
                        .map(quizResponseMapper)
                        .toArray(QuizResponse[]::new))
                .toList();

        for (int i = 0; i < quizQuestions.size(); i++) {
            quizQuestions.get(i).add(quizResponses.get(i));
        }

        quizQuestions.forEach(quiz::add);

        user.add(quiz);

        userRepo.save(user);

    }

    @Override
    public void editQuiz(QuizDTO quizDTOData) {

       Quiz quizOptional = quizRepo.findById(quizDTOData.getId());

        quizOptional.setCategory(quizDTOData.getCategory());
        quizOptional.setDifficulty(quizDTOData.getDifficulty());
        quizOptional.setName(quizDTOData.getName());
        quizOptional.setStatus(quizDTOData.getStatus());

            quizRepo.save(quizOptional);
    }

    @Override
    public List<QuizDTO> getAllQuiz() {
        List<Quiz> quizList = quizRepo.findAll();
        return quizList.stream()
                .map(quiz -> quizDTOMapper.apply(quiz))
                .collect(Collectors.toList());
   }

    @Override
    public QuizDTO getQuizById(int quizId) {
        Quiz quizOptional = quizRepo.findById(quizId);

        return quizDTOMapper.apply(quizOptional);
    }

    @Override
    public List<QuizDTO> getQuizesMadeByUser(int userId) {
        User user = userRepo.findById(userId);

        List<Quiz> quizzes = user.getQuizzes();

        return quizzes.stream()
                .map(quizDTOMapper)
                .collect(Collectors.toList());
    }

}
