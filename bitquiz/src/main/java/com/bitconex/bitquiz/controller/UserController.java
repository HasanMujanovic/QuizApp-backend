package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.userResponse.UserResponse;
import com.bitconex.bitquiz.PasswordSecurity.CredentialsDTO;
import com.bitconex.bitquiz.PasswordSecurity.RegisterDTO;
import com.bitconex.bitquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bit/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        UserDTO userDTO = userService.getUser(email);
        return ResponseEntity.ok(UserDTO.dtoToResponse(userDTO));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(UserDTO.dtoToResponse(userDTO));
    }

    @PostMapping("/save-status/{status}/{email}")
    public void saveStatus(@PathVariable String status,@PathVariable String email){
        userService.saveUserStatus(status,email);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<UserResponse>> getTop5UsersSortedByLevelAndPoints() {
        List<UserDTO> users = userService.getTop5UsersSortedByLevelAndPoints();
        return ResponseEntity.ok(users.stream().map(UserDTO::dtoToResponse).collect(Collectors.toList()));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody CredentialsDTO credentialsDTO){
        UserDTO user = userService.loginAuth(credentialsDTO);
        return ResponseEntity.ok(UserDTO.dtoToResponse(user));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterDTO registerDTO){
        UserDTO user = userService.register(registerDTO);
        return ResponseEntity.ok(UserDTO.dtoToResponse(user));
    }

}
