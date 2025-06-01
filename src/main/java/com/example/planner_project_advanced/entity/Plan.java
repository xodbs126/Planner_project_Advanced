package com.example.planner_project_advanced.entity;

import com.example.planner_project_advanced.dto.CreatePlanDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
public class Plan {


    @Id
    private Long id;
    @NotBlank(message = "내용은 필수 입력값입니다.")
    @Size(max=200,message = "최대 길이는 200자입니다.")
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;

    public Plan() {
    }

    public Plan(Long userId, CreatePlanDTO createPlanDTO) {
        this.userId = userId;
        this.content = createPlanDTO.getContent();
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        this.editedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }
}
