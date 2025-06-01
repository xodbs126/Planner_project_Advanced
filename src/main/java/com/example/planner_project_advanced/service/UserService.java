package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.UserRegisterDTO;
import com.example.planner_project_advanced.entity.User;
import jakarta.validation.Valid;

public interface UserService {
    UserRegisterDTO registerUser(@Valid UserRegisterDTO registerDTO);

    User findUserById(Long userId);

    void updateUserName(Long userId, String name);
}
