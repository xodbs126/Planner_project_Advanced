package com.example.planner_project_advanced.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Plan {


    @Id
    private Long id;

    @NotBlank(message = "내용은 필수 입력값입니다.")
    @Size(max=200,message = "최대 길이는 200자입니다.")
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;

}
