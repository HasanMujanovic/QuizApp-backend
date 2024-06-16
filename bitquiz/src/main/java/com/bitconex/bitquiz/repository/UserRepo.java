package com.bitconex.bitquiz.repository;

import com.bitconex.bitquiz.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findById(int id);
    List<User> findByOrderByLevelDescPointsDesc(Pageable pageable);
}
