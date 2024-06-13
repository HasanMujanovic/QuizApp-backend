package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.MakeQuizDto;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.QuizDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.UserDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.QuizMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.QuizQuestionsMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.QuizResponseMapper;
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
   private UserDTOMapper userDTOMapper;
   private QuizQuestionsMapper quizQuestionsMapper;
   private QuizResponseMapper quizResponseMapper;

    @Autowired
    public QuizServiceImpl(UserRepo userRepo, QuizRepo quizRepo, QuizDTOMapper quizDTOMapper,
                           QuizMapper quizMapper, UserDTOMapper userDTOMapper,
                           QuizQuestionsMapper quizQuestionsMapper, QuizResponseMapper quizResponseMapper) {
        this.userRepo = userRepo;
        this.quizRepo = quizRepo;
        this.quizDTOMapper = quizDTOMapper;
        this.quizMapper = quizMapper;
        this.userDTOMapper = userDTOMapper;
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

    @Override
    public UserDTO getAdminByQuizId(int quizId) {
        Quiz quiz = quizRepo.findById(quizId);
        User user = quiz.getUser();

        return userDTOMapper.apply(user);
    }

}
