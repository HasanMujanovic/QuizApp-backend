package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "quizes")
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
