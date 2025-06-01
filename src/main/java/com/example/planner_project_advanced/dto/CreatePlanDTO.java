package com.example.planner_project_advanced.dto;

import com.example.planner_project_advanced.entity.Plan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Getter
public class CreatePlanDTO {

    @Size(max = 200,message = "최대 200자 입니다.")
    private String content;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    public CreatePlanDTO(Plan plan) {
        this.content = plan.getContent();
    }

    public CreatePlanDTO() {
    }
}
