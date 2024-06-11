package com.bitconex.bitquiz.repository;

import com.bitconex.bitquiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
