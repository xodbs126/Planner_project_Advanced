package com.example.planner_project_advanced.entity;

import com.example.planner_project_advanced.dto.UserRegisterDTO;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class User {

    @Id
    private Long id;

    private String name;

    private String password;

    private Long planId;

    private LocalDateTime createdAt;

    private String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }
}
