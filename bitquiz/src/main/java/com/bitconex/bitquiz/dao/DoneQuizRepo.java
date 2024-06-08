package com.bitconex.bitquiz.dao;

import com.bitconex.bitquiz.entity.DoneQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoneQuizRepo extends JpaRepository<DoneQuiz, Integer> {
}
