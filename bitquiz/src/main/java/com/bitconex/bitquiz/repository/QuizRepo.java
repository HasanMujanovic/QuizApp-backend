package com.bitconex.bitquiz.repository;

import com.bitconex.bitquiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "quizes")
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
    Quiz findById(int id);

    @Query("SELECT q FROM Quiz q WHERE "
            + "(:category IS NULL OR q.category = :category) AND "
            + "(:difficulty IS NULL OR q.difficulty = :difficulty)")
    List<Quiz> findByCategoryAndDifficulty(
            @Param("category") String category,
            @Param("difficulty") String difficulty);
}
