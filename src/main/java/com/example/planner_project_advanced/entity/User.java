package com.example.planner_project_advanced.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
public class User {

    @Id
    private Long id;

    private String name;

    private String password;

    private LocalDateTime createdAt;

    private String email;

    public User() {
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }


}
