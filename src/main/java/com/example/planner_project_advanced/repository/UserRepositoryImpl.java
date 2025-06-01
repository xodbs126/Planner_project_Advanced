package com.example.planner_project_advanced.repository;

import com.example.planner_project_advanced.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void userSave(User user) {
        String sql = "INSERT INTO users (name, password, email, created_at) VALUES (?, ?, ?, NOW())";
        jdbcTemplate.update(sql,
                user.getName(),
                user.getPassword(),
                user.getEmail()
        );
    }

    @Override
    public List<User> findAllUser() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public void updateUserName(Long userId, String name) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, userId);
    }


    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));

            Timestamp createdAt = rs.getTimestamp("created_at");
            if (createdAt != null) {
                user.setCreatedAt(createdAt.toLocalDateTime());
            }

            return user;
        }
    }
}
