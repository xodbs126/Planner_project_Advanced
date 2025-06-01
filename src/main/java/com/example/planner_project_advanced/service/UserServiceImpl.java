package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.UserRegisterDTO;
import com.example.planner_project_advanced.entity.User;
import com.example.planner_project_advanced.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRegisterDTO registerUser(UserRegisterDTO registerDTO) {
        User user = new User(registerDTO.getUserName(), registerDTO.getPassword(), registerDTO.getEmail());
        userRepository.userSave(user);

        return new UserRegisterDTO(user);
    }
}
