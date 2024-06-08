package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.QuizProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "progress")
public interface QuizProgressRepo extends JpaRepository<QuizProgress, Integer> {
}
