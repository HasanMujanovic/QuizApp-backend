package com.bitconex.bitquiz.repository;

import com.bitconex.bitquiz.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
   Optional<User> findByEmail(String email);
   Optional<User> findById(int id);
    List<User> findByOrderByLevelDescPointsDesc(Pageable pageable);
}
