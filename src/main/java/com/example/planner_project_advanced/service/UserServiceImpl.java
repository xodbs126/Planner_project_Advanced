package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.UserRegisterDTO;
import com.example.planner_project_advanced.entity.User;
import com.example.planner_project_advanced.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> allUser = new ArrayList<>();
    @Override
    public UserRegisterDTO registerUser(UserRegisterDTO registerDTO) {
        User user = new User(registerDTO.getUserName(), registerDTO.getPassword(), registerDTO.getEmail());
        userRepository.userSave(user);

        return new UserRegisterDTO(user);
    }

    @Override
    public User findUserById(Long userId) {
        allUser =userRepository.findAllUser();

        for (User user : allUser) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateUserName(Long userId, String name) {
        userRepository.updateUserName(userId, name);
    }
}
