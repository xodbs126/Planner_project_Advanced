package com.example.planner_project_advanced.repository;


import com.example.planner_project_advanced.dto.CreatePlanDTO;
import com.example.planner_project_advanced.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlanRepositoryImpl implements PlanRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlanRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPlan(Plan plan) {
        String insertSql = "INSERT INTO plans (content, user_id, created_at, edited_at) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertSql,
                plan.getContent(),
                plan.getUserId(),
                plan.getCreatedAt(),
                plan.getEditedAt()
        );
    }

    @Override
    public Page<Plan> findAll(String updatedDate, String userName, Long userId, int page, int size) {
        StringBuilder querySql = new StringBuilder(
                "SELECT " +
                        "p.id, " +
                        "p.content, " +
                        "p.created_at, " +
                        "p.edited_at, " +
                        "u.id AS user_id, " +
                        "u.name AS user_name, " +
                        "u.email, " +
                        "COUNT(*) OVER() AS total_count " +
                        "FROM plans p " +
                        "JOIN users u ON p.user_id = u.id " +
                        "WHERE 1=1 "
        );

        List<Object> params = new ArrayList<>();

        if (updatedDate != null && !updatedDate.isEmpty()) {
            querySql.append("AND DATE(p.edited_at) = ? ");
            params.add(LocalDate.parse(updatedDate));
        }

        if (userName != null && !userName.isEmpty()) {
            querySql.append("AND u.name = ? ");
            params.add(userName);
        }

        if (userId != null) {
            querySql.append("AND u.id = ? ");
            params.add(userId);
        }

        querySql.append("ORDER BY p.edited_at DESC ");
        querySql.append("LIMIT ? OFFSET ? ");
        params.add(size);
        params.add(page * size);

        return jdbcTemplate.query(querySql.toString(), rs -> {
            List<Plan> plans = new ArrayList<>();
            int total = 0;
            while (rs.next()) {
                if (total == 0) {
                    total = rs.getInt("total_count");
                }

                Plan plan = new Plan();
                plan.setId(rs.getLong("id"));
                plan.setContent(rs.getString("content"));
                plan.setUserId(rs.getLong("user_id"));
                plan.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                plan.setEditedAt(rs.getTimestamp("edited_at").toLocalDateTime());
                plans.add(plan);
            }

            return new PageImpl<>(plans, PageRequest.of(page, size), total);
        }, params.toArray());
    }

    private static class PlanRowMapper implements RowMapper<Plan> {
        @Override
        public Plan mapRow(ResultSet rs, int rowNum) throws SQLException {
            Plan plan = new Plan();
            plan.setId(rs.getLong("id"));
            plan.setContent(rs.getString("content"));
            plan.setUserId(rs.getLong("user_id"));
            plan.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            plan.setEditedAt(rs.getTimestamp("edited_at").toLocalDateTime());
            return plan;
        }
    }
}

