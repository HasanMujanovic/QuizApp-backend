package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dto.QuizProgressDTO;
import com.bitconex.bitquiz.dto.QuizQuestionsDTO;
import com.bitconex.bitquiz.dto.QuizResponseDTO;
import com.bitconex.bitquiz.dto.mappers.toDTO.QuizProgressDTOMapper;
import com.bitconex.bitquiz.dto.mappers.toDTO.QuizQuestionsDTOMapper;
import com.bitconex.bitquiz.dto.mappers.toDTO.QuizResponseDTOMapper;
import com.bitconex.bitquiz.entity.*;
import com.bitconex.bitquiz.repository.QuizQuestionsRepo;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.PlayingQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayingQuizServiceImpl implements PlayingQuizService {
    private QuizRepo quizRepo;
    private QuizQuestionsDTOMapper quizQuestionsDTOMapper;
    private QuizQuestionsRepo quizQuestionsRepo;
    private QuizResponseDTOMapper quizResponseDTOMapper;
    private UserRepo userRepo;
    private QuizProgressDTOMapper quizProgressDTOMapper;

    @Autowired
    public PlayingQuizServiceImpl(QuizRepo quizRepo, QuizQuestionsDTOMapper quizQuestionsDTOMapper,
                                  QuizQuestionsRepo quizQuestionsRepo, QuizResponseDTOMapper quizResponseDTOMapper,
                                  UserRepo userRepo, QuizProgressDTOMapper quizProgressDTOMapper) {
        this.quizRepo = quizRepo;
        this.quizQuestionsDTOMapper = quizQuestionsDTOMapper;
        this.quizQuestionsRepo = quizQuestionsRepo;
        this.quizResponseDTOMapper = quizResponseDTOMapper;
        this.userRepo = userRepo;
        this.quizProgressDTOMapper = quizProgressDTOMapper;
    }

    @Override
    public List<QuizQuestionsDTO> getQuizQuestionsByQuizId(int quizId) {
        Quiz quiz = quizRepo.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + quizId));

        List<QuizQuestions> quizQuestions = quiz.getQuestions();

        return quizQuestions.stream()
                .map(quizQuestionsDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuizResponseDTO> getQuizResponsesByQuestionId(long questionId) {
        QuizQuestions quizQuestion = quizQuestionsRepo.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Quiz question not found with id: " + questionId));

        List<QuizResponse> quizResponses = quizQuestion.getResponses();

        return quizResponses.stream()
                .map(quizResponseDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuizProgressDTO> getQuizProgressByUserId(int userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        List<QuizProgress> quizProgressList = user.getQuizProgresses();


        return quizProgressList.stream()
                .map(quizProgressDTOMapper)
                .collect(Collectors.toList());    }
}
