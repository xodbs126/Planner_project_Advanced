package com.example.planner_project_advanced.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegisterDTO {


    @NotBlank(message = "사용자의 이름은 필수 입력값입니다.")
    private String userName;
    @NotBlank(message = "사용자의 비밀번호는 필수 입력값입니다.")
    private String password;

    @Email(message = "이메일 형식을 지켜주세요.")
    private String email;




}
