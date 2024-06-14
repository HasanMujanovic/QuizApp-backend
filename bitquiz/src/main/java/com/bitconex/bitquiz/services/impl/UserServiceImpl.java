package com.bitconex.bitquiz.services.impl;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.UserDTOMapper;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private UserDTOMapper userDTOMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserDTOMapper userDTOMapper) {
        this.userRepo = userRepo;
        this.userDTOMapper = userDTOMapper;
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
    public UserDTO getUserById(int userId) {
        User user = userRepo.findById(userId);
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

    @Override
    public void saveUserStatus(String status, String email) {
        User user = userRepo.findByEmail(email);
        user.setStatus(status);
        userRepo.save(user);
    }

    @Override
    public List<UserDTO> getTop5UsersSortedByLevelAndPoints() {
    List<User> users = userRepo.findByOrderByLevelDescPointsDesc(PageRequest.of(0,5));

    return users.stream().map(res -> userDTOMapper.apply(res)).collect(Collectors.toList());

    }
}
