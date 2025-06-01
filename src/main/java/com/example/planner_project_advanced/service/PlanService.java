package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.dto.PlanResponseDTO;
import com.example.planner_project_advanced.dto.PlanUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface PlanService {
    CreatePlanDTO createPlan(Long userId, CreatePlanDTO createPlanDTO);

    Page<PlanResponseDTO> findAll(String updatedDate, String userName, Long userId, int page, int size);

    PlanResponseDTO updatePlan(Long planId,Long userId, @Valid PlanUpdateDTO planUpdateDTO);
}
