package com.example.planner_project_advanced.service;

import com.example.planner_project_advanced.dto.CreatePlanDTO;

public interface PlanService {
    CreatePlanDTO createPlan(Long userId, CreatePlanDTO createPlanDTO);
}
