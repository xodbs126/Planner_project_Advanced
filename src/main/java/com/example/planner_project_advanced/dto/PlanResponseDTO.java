package com.example.planner_project_advanced.dto;


import com.example.planner_project_advanced.entity.Plan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PlanResponseDTO {
    private String content;
    private String userName;

    public PlanResponseDTO(@NotBlank(message = "내용은 필수 입력값입니다.") @Size(max = 200, message = "최대 길이는 200자입니다.") String content, String userName) {
        this.content = content;
        this.userName =userName;
    }

    public PlanResponseDTO(Plan plan,String userName) {
        this.content = plan.getContent();
        this.userName = userName;
    }
}
