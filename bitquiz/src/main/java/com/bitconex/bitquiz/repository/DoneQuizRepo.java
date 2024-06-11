package com.bitconex.bitquiz.repository;

import com.bitconex.bitquiz.entity.DoneQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoneQuizRepo extends JpaRepository<DoneQuiz, Integer> {
    Page<DoneQuiz> findByQuizEndIdOrderByPointsWonDescTimeLeftDesc(int quizId, Pageable pageable);
}
