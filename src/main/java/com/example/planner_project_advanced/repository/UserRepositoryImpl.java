package com.example.planner_project_advanced.repository;


import com.example.planner_project_advanced.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{


    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void userSave(User user) {
        String userName = user.getName();
        String password = user.getPassword();
        String email = user.getEmail();

        String sql = "INSERT INTO users (name, password, email, created_at) VALUES (?, ?, ?, NOW())";
        jdbcTemplate.update(sql, userName, password, email);
    }
}
