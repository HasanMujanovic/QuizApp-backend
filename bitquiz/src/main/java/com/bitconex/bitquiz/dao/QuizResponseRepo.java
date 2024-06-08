package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.QuizResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "quiz-response")
public interface QuizResponseRepo extends JpaRepository<QuizResponse,Long> {
}
