package com.example.planner_project_advanced.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePlanDTO {

    @Size(max = 200,message = "최대 200자 입니다.")
    private String content;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

}
