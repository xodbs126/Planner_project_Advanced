package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.UserRegisterDTO;
import jakarta.validation.Valid;

public interface UserService {
    UserRegisterDTO registerUser(@Valid UserRegisterDTO registerDTO);
}
