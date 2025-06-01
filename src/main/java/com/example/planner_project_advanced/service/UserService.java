package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.UserRegisterDTO;
import com.example.planner_project_advanced.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface UserService {
    UserRegisterDTO registerUser(@Valid UserRegisterDTO registerDTO);

    User findUserById(Long userId);

    void updateUserName(Long userId, String name);


    User findUserByName(@NotBlank(message = "사용자의 이름은 필수 입력값입니다.") String userName);
}
