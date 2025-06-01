package com.example.planner_project_advanced.repository;

import com.example.planner_project_advanced.entity.User;

import java.util.List;

public interface UserRepository {
    void userSave(User user);

    List<User> findAllUser();

    void updateUserName(Long userId, String name);
}
