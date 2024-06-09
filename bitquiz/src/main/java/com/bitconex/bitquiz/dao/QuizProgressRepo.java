package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "progress")
public interface QuizProgressRepo extends JpaRepository<QuizProgress, Integer> {
    Optional<QuizProgress> findByUserSavedAndQuizId(User userSaved, int quizId);

}
