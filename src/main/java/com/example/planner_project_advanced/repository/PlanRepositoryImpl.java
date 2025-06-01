package com.example.planner_project_advanced.repository;


import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.entity.Plan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlanRepositoryImpl implements PlanRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlanRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPlan(Plan plan) {
        String sql = "INSERT INTO plans (content, user_id, created_at, edited_at) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                plan.getContent(),
                plan.getUserId(),
                plan.getCreatedAt(),
                plan.getEditedAt()
        );


    }
}

