package com.example.planner_project_advanced.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PlanUpdateDTO {

    @NotBlank(message = "변경할 이름을 작성해주세요.")
    private String userName;
    @Size(max=200,message = "최대 200자 입니다.")
    @NotBlank(message = "Plan 내용은  필수 입력값입니다.")
    private String content;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
