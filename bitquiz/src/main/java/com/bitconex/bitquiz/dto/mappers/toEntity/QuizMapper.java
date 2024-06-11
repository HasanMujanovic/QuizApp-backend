package com.bitconex.bitquiz.dto.mappers.toEntity;

import com.bitconex.bitquiz.dto.QuizDTO;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.repository.DoneQuizRepo;
import com.bitconex.bitquiz.repository.QuizQuestionsRepo;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizMapper implements Function<QuizDTO, Quiz> {

    private QuizQuestionsRepo quizQuestionsRepo;
    private DoneQuizRepo doneQuizRepo;

    public QuizMapper(QuizQuestionsRepo quizQuestionsRepo, DoneQuizRepo doneQuizRepo) {
        this.quizQuestionsRepo = quizQuestionsRepo;
        this.doneQuizRepo = doneQuizRepo;
    }

    @Override
    public Quiz apply(QuizDTO dto) {
        Quiz quiz = new Quiz();
        quiz.setId(dto.getId());
        quiz.setCategory(dto.getCategory());
        quiz.setStatus(dto.getStatus());
        quiz.setDifficulty(dto.getDifficulty());
        quiz.setName(dto.getName());
        quiz.setLikes(dto.getLikes());
        quiz.setDoneIt(dto.getDoneIt());
        quiz.setTime(dto.getTime());
        quiz.setPoints(dto.getPoints());


        return quiz;
    }
}