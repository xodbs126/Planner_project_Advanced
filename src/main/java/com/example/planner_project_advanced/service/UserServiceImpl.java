package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.UserRegisterDTO;
import com.example.planner_project_advanced.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;

    @Override
    public UserRegisterDTO registerUser(UserRegisterDTO registerDTO) {
        User user = new User(registerDTO.getUserName(), registerDTO.getPassword(), registerDTO.getEmail());
        userRepository.userSave(user);

        return new UserRegisterDTO(user);
    }
}
