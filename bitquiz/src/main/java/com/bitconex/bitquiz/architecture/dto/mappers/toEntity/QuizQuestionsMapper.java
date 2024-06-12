package com.bitconex.bitquiz.architecture.dto.mappers.toEntity;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.entity.QuizQuestions;
import com.bitconex.bitquiz.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizQuestionsMapper implements Function<QuizQuestionsDTO, QuizQuestions> {
    @Autowired
    QuizRepo quizRepo;
    @Override
    public QuizQuestions apply(QuizQuestionsDTO quizQuestionsDTO) {
        QuizQuestions question = new QuizQuestions();
        question.setId(quizQuestionsDTO.getId());
        question.setText(quizQuestionsDTO.getText());
        question.setPoints(quizQuestionsDTO.getPoints());
        question.setHelpAllowed(quizQuestionsDTO.isHelpAllowed());
        question.setMinusPoints(quizQuestionsDTO.getMinusPoints());
        return question;
    }
}
