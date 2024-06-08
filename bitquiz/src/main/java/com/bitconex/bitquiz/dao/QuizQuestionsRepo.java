package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.QuizQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "quiz-questions")
public interface QuizQuestionsRepo extends JpaRepository<QuizQuestions,Long> {
}
