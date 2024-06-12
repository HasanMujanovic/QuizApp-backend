package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.UserDTO;
import com.bitconex.bitquiz.dto.UserLoginDTO;
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
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        UserDTO userDTO = userService.getUser(email);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkIfUserExists(@RequestParam String email) {
        boolean exists = userService.checkIfUserExistsSignUp(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/checkUserLogIn")
    public ResponseEntity<Boolean> checkIfUserExistsLogIn(@RequestBody UserLoginDTO userLoginDTO) {
        boolean userExists = userService.checkIfUserExistsLogIn(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        return ResponseEntity.ok(userExists);
    }

  
}
