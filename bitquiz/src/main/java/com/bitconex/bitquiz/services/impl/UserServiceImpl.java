package com.bitconex.bitquiz.services.impl;

import com.bitconex.bitquiz.ErrorMessage.AppException;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.UserDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.UserMapper;
import com.bitconex.bitquiz.PasswordSecurity.CredentialsDTO;
import com.bitconex.bitquiz.PasswordSecurity.RegisterDTO;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private UserDTOMapper userDTOMapper;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserDTOMapper userDTOMapper,
                           PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userDTOMapper = userDTOMapper;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }



    @Override
    public UserDTO getUser(String email) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            return userDTOMapper.apply(user);
        } else {
            throw new AppException("Cannot find user", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public UserDTO getUserById(int userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            return userDTOMapper.apply(user);
        } else {
            throw new AppException("Cannot find user", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void saveUserStatus(String status, String email) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setStatus(status);
            userRepo.save(user);
        }

    }

    @Override
    public List<UserDTO> getTop5UsersSortedByLevelAndPoints() {
    List<User> users = userRepo.findByOrderByLevelDescPointsDesc(PageRequest.of(0,5));

    return users.stream().map(res -> userDTOMapper.apply(res)).collect(Collectors.toList());
    }

    @Override
    public UserDTO loginAuth(CredentialsDTO credentialsDTO) {
        Optional<User> userOptional = userRepo.findByEmail(credentialsDTO.email());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if (passwordEncoder.matches(credentialsDTO.password(), user.getPassword())){
                return userDTOMapper.apply(user);
            }
        }

        throw new AppException("Invalid credentials", HttpStatus.BAD_REQUEST);

    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) {
        UserDTO userDTO = registerDTO.getUserDTO();
        Optional<User> userOptional = userRepo.findByEmail(registerDTO.getUserDTO().getEmail());
        if (userOptional.isPresent()){
            throw new AppException("User already exists", HttpStatus.BAD_REQUEST);
        }
        User user1 = userMapper.apply(registerDTO.getUserDTO());
        user1.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        User user2 = userRepo.save(user1);
        return userDTOMapper.apply(user2);
    }


}
