package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.dto.UserDTO;
import com.bitconex.bitquiz.dto.mappers.toDTO.UserDTOMapper;
import com.bitconex.bitquiz.dto.mappers.toEntity.UserMapper;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private UserDTOMapper userDTOMapper;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserDTOMapper userDTOMapper,
                           UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userDTOMapper = userDTOMapper;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public UserDTO getUser(String email) {
        User user = userRepo.findByEmail(email);
        return userDTOMapper.apply(user);
    }

    @Override
    public boolean checkIfUserExistsSignUp(String email) {
        User user = userRepo.findByEmail(email);

        return user != null;

    }

    @Override
    public boolean checkIfUserExistsLogIn(String email, String password) {
        User user = userRepo.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}