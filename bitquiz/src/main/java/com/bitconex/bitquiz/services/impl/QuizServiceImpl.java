package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.ErrorMessage.AppException;
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
import com.bitconex.bitquiz.entity.*;
import com.bitconex.bitquiz.repository.CategoryRepository;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
   private CategoryRepository categoryRepository;

    @Autowired
    public QuizServiceImpl(UserRepo userRepo, QuizRepo quizRepo, QuizDTOMapper quizDTOMapper,
                           QuizMapper quizMapper, UserDTOMapper userDTOMapper,
                           QuizQuestionsMapper quizQuestionsMapper, QuizResponseMapper quizResponseMapper,
                           CategoryRepository categoryRepository) {
        this.userRepo = userRepo;
        this.quizRepo = quizRepo;
        this.quizDTOMapper = quizDTOMapper;
        this.quizMapper = quizMapper;
        this.userDTOMapper = userDTOMapper;
        this.quizQuestionsMapper = quizQuestionsMapper;
        this.quizResponseMapper = quizResponseMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void makeQuiz(MakeQuizDto makeQuizDto) {
        QuizDTO quizDto = makeQuizDto.getQuiz();
        UserDTO userDto = makeQuizDto.getUser();

        Quiz quiz = quizMapper.apply(quizDto);
        Optional<User> userOptional = userRepo.findByEmail(userDto.getEmail());
        User user = new User();
        if (userOptional.isPresent()){
            user = userOptional.get();
        } else {
            throw new AppException("Couldn't find User", HttpStatus.BAD_REQUEST);

        }

        Category category1 = categoryRepository.findByName(quiz.getCategory());

        if (category1 == null){
            Category category = new Category();
            category.setName(quiz.getCategory());

            categoryRepository.save(category);
        }

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

      Optional<Quiz> quizOptional = quizRepo.findById(quizDTOData.getId());

      if(quizOptional.isPresent()){
          Quiz quiz = quizOptional.get();
          quiz.setCategory(quizDTOData.getCategory());
          quiz.setDifficulty(quizDTOData.getDifficulty());
          quiz.setName(quizDTOData.getName());
          quiz.setStatus(quizDTOData.getStatus());

          quizRepo.save(quiz);
      } else {
          throw new AppException("Couldn't find Quiz", HttpStatus.BAD_REQUEST);
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
    public QuizDTO getQuizById(int quizId) {
       Optional<Quiz> quizOptional = quizRepo.findById(quizId);

       if (quizOptional.isPresent()){
           Quiz quiz = quizOptional.get();
           return quizDTOMapper.apply(quiz);
       } else {
           throw new AppException("Couldn't find Quiz", HttpStatus.BAD_REQUEST);

       }

    }

    @Override
    public List<QuizDTO> getQuizesMadeByUser(int userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        User user = new User();
        if (userOptional.isPresent()){
            user = userOptional.get();
        } else {
            throw new AppException("Couldn't find User", HttpStatus.BAD_REQUEST);

        }

        List<Quiz> quizzes = user.getQuizzes();

        return quizzes.stream()
                .map(quizDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getAdminByQuizId(int quizId) {
        Optional<Quiz> quizOptional = quizRepo.findById(quizId);

        if (quizOptional.isPresent()){
            Quiz quiz = quizOptional.get();
            User user = quiz.getUser();

            return userDTOMapper.apply(user);
        } else {
            throw new AppException("Couldn't find Quiz", HttpStatus.BAD_REQUEST);
        }

    }

    @Transactional
    @Override
    public void deleteQuiz(int quizId, int userId) {
        Optional<User> userOptional = userRepo.findById(userId);

        Optional<Quiz> quizOptional = quizRepo.findById(quizId);

        if (quizOptional.isPresent() && userOptional.isPresent()){
            Quiz quiz = quizOptional.get();
            User user = userOptional.get();
            user.removeQuiz(quiz);
        } else {
            throw new AppException("Couldn't find Quiz or User", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public void likeingQuiz(int quizId) {
        Optional<Quiz> quizOptional = quizRepo.findById(quizId);

        if(quizOptional.isPresent()){
            Quiz quiz = quizOptional.get();
            quiz.setLikes(quiz.getLikes() + 1);
            quizRepo.save(quiz);
        } else {
            throw new AppException("Couldn't find Quiz", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public List<QuizDTO> filteredQuizes(String category, String difficulty) {
        List<Quiz> quizList = quizRepo.findByCategoryAndDifficulty(category, difficulty);
        return quizList.stream()
                .map(quizDTOMapper)
                .collect(Collectors.toList());
    }

}
