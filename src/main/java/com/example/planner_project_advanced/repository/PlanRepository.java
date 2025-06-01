package com.example.planner_project_advanced.repository;

import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.entity.Plan;
import com.example.planner_project_advanced.entity.User;

public interface PlanRepository {
    void createPlan(Plan plan);
}
