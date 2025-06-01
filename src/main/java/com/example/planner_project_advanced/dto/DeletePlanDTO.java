package com.example.planner_project_advanced.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DeletePlanDTO {


    @NotNull(message = "ID는 필수입니다.")
    private Long id;
    @NotBlank(message = "사용자의 이름은 필수 입력값입니다.")
    private String userName;

    @NotBlank(message = "사용자의 비밀번호는 필수 입력값입니다.")
    private String password;
}
