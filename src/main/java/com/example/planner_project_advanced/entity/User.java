package com.example.planner_project_advanced.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class User {

    @Id
    private Long id;

    @NotBlank(message = "사용자 이름은 필수 값입니다.")
    private String name;

    @NotBlank(message = "사용자 비밀번호는 필수 값입니다.")
    private String password;

    private Long planId;

    private LocalDateTime createdAt;

    @Email(message = "이메일 형식으로 입력 바랍니다.")
    private String email;
}
