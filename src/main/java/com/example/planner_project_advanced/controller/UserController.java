package com.example.planner_project_advanced.controller;

import com.example.planner_project_advanced.dto.UserRegisterDTO;
import com.example.planner_project_advanced.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> userRegister(
            @RequestBody @Valid UserRegisterDTO registerDTO){
        return new ResponseEntity<>(userService.registerUser(registerDTO), HttpStatus.CREATED);
    }


}
