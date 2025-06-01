package com.example.planner_project_advanced.repository;

import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.entity.Plan;
import com.example.planner_project_advanced.entity.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;

public interface PlanRepository {
    void createPlan(Plan plan);

    Page<Plan> findAll(String updatedDate, String userName, Long userId, int page, int size);

    Plan updatePlan(Long planId,Long userId, String content);

    Plan findPlanById(Long planId);

    void deletePlan(Long userId, @NotBlank(message = "PlanID의 값은 필수 입력값입니다.") Long planId);

}
