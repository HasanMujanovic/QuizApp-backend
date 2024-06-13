package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserLoginDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.usersRequest.UserLoginRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.userResponse.UserResponse;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bit/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        UserDTO userDTO = userService.getUser(email);
        return ResponseEntity.ok(UserDTO.dtoToResponse(userDTO));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable int id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(UserDTO.dtoToResponse(userDTO));
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkIfUserExists(@RequestParam String email) {
        boolean exists = userService.checkIfUserExistsSignUp(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/checkUserLogIn")
    public ResponseEntity<Boolean> checkIfUserExistsLogIn(@RequestBody UserLoginRequest userLoginRequest) {
        UserLoginDTO userLoginDTO = UserLoginDTO.requestToResponse(userLoginRequest);
        boolean userExists = userService.checkIfUserExistsLogIn(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        return ResponseEntity.ok(userExists);
    }

  
}
